package com.phamtan.base.config;

import com.phamtan.base.pojo.EmailConfigProperties;
import com.phamtan.base.pojo.OneSignalProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

import java.util.Properties;

@Configuration
public class EmailConfig {
    @Bean(name = "emailConfigProperties")
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    @ConfigurationProperties(prefix = "phamtan.email")
    public EmailConfigProperties emailConfigBean(){
        return new EmailConfigProperties();
    }

    @Bean(name = "javaMailSender")
    @Primary
    @ConditionalOnBean(name = "emailConfigProperties")
    public JavaMailSenderImpl javaMailSender(){
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(emailConfigBean().getHost());
        javaMailSender.setPort(emailConfigBean().getPort());
        javaMailSender.setUsername(emailConfigBean().getUsername());
        javaMailSender.setPassword(emailConfigBean().getPassword());
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", emailConfigBean().getStmpAuth().toString());
        properties.setProperty("mail.smtp.starttls.enable", emailConfigBean().getStarttls().toString());
        javaMailSender.setJavaMailProperties(properties);
        return javaMailSender;
    }
    @Primary
    @Bean
    public FreeMarkerConfigurationFactoryBean fmfbean() {
        FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
        bean.setTemplateLoaderPath("classpath:/templates");
        return bean;
    }
}
