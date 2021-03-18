package com.phamtan.base.config;

import com.phamtan.base.pojo.OneSignalProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration(proxyBeanMethods = true)
public class OneSignalConfiguration {
    @Bean
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    @ConfigurationProperties(prefix = "phamtan.onesignal")
    public OneSignalProperties oneSignalBean(){
        return new OneSignalProperties();
    }

}
