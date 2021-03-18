package com.phamtan.base.email.request;

import com.phamtan.base.email.data_structure.EmailContentData;
import com.phamtan.base.enumeration.EmailEnum;
import org.springframework.mail.SimpleMailMessage;

import java.util.Date;
import java.util.List;

public class SimpleEmailMessageImpl {
    public SimpleMailMessage create(EmailRequest emailRequest){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(emailRequest.getFrom());
        simpleMailMessage.setTo(emailRequest.getTo());
        simpleMailMessage.setSentDate(new Date());
        simpleMailMessage.setSubject(emailRequest.getSubject());
        List<EmailContentData> data = emailRequest.getContent();
        StringBuilder content= new StringBuilder();
        for(EmailContentData emailContentData : data){
            if(emailContentData.getKey().equals(EmailEnum.TEXT)){
                content.append(emailContentData.getValue().getData()).append("\n");
            }
        }
        simpleMailMessage.setText(content.toString());
        return simpleMailMessage;
    }
}
