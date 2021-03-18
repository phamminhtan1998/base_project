package com.phamtan.base;

import com.phamtan.base.pojo.OneSignalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.ConnectException;

@SpringBootApplication

public class BaseApplication {
    @Autowired
    private OneSignalProperties oneSignalProperties;
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }

}
