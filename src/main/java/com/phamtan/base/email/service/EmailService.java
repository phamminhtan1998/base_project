package com.phamtan.base.email.service;

import com.phamtan.base.email.data_structure.EmailContentData;
import com.phamtan.base.email.data_structure.FileRecord;
import com.phamtan.base.email.request.EmailRequest;
import com.phamtan.base.email.request.SimpleEmailMessageImpl;
import com.phamtan.base.enumeration.EmailEnum;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmailService {
    @Autowired
    JavaMailSenderImpl javaMailSender ;
    @Autowired
    ResourceLoader resourceLoader;

    public  void sendEmail(EmailRequest emailRequest){
        SimpleEmailMessageImpl simpleEmailMessage = new SimpleEmailMessageImpl();
        SimpleMailMessage message = simpleEmailMessage.create(emailRequest);
        javaMailSender.send(message);
    }

    @Autowired
    private Configuration configuration;

    public String sendMailWithAttachments(EmailRequest request,Template template) throws MessagingException {

        String response;
        MimeMessage message = javaMailSender.createMimeMessage();
        Map<String, String> model = new HashMap<>();
        List<FileRecord> fileRecordList = new ArrayList<>();

        try {
            List<File> file = new ArrayList<>();
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            
            List<EmailContentData> data = request.getContent();

            for(EmailContentData email : data){
                if(email.getKey().equals(EmailEnum.IMAGE)){
                    File fileTmp = new File(email.getData());
                    fileRecordList.add(new FileRecord(email.getName(),fileTmp));
                }
                else if(email.getKey().equals(EmailEnum.FILE)){
                    File fileTmp = new File(email.getData());
                    helper.addAttachment(email.getName(),fileTmp);
                }
                else if(email.getKey().equals(EmailEnum.TEXT)){
                    model.put(email.getName(), email.getData());
                }
            }
            helper.setTo(request.getTo());
            helper.setFrom(request.getFrom());
            helper.setSubject(request.getSubject());
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            helper.setText(html, true);
            for (FileRecord fileRecord:fileRecordList){
                helper.addInline(fileRecord.getName(),fileRecord.getFile());
            }
            javaMailSender.send(message);
            response = "Email has been sent to :" + request.getTo();
        } catch (MessagingException | IOException | TemplateException e) {
            response = "Email send failure to :" + request.getTo();
        }
        return response;
    }
}

