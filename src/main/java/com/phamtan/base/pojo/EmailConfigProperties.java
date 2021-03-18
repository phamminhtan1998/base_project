package com.phamtan.base.pojo;

import com.phamtan.base.pojo.OneSignalProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailConfigProperties {


    /**
     * SMTP server host. For instance, `smtp.example.com`.
     */
    private String host;

    /**
     * SMTP server port.
     */
    private Integer port;

    /**
     * Login user of the SMTP server.
     */
    private String username;

    /**
     * Login password of the SMTP server.
     */
    private String password;

    /**
     * Protocol used by the SMTP server.
     */
    private String protocol = "smtp";

    /**
     * Default MimeMessage encoding.
     */
    private Charset defaultEncoding = StandardCharsets.UTF_8;;

    /**
     * What if Turn on stmp auth
     */
    private Boolean stmpAuth;
    /**
     * What if Turn on stmp auth
     */
    private Boolean starttls;


}
