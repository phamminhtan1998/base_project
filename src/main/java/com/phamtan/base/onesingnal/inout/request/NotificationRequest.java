package com.phamtan.base.onesingnal.inout.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.phamtan.base.config.OneSignalConfiguration;
import com.phamtan.base.enumeration.OneSignalLanguage;
import com.phamtan.base.pojo.OneSignalProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Notification request.
 * Define notification request properties to create a notification;
 * @author Pham Minh Tan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class NotificationRequest {

    /**
     *  App id of one signal
     */
    @JsonProperty("app_id")
    private String appId;
    /**
     *  Type of received notification (subscribed,all,...)
     *  Default to all user subscribed
     */
    @JsonProperty("included_segments")
    private List<String> includedSegments= Arrays.asList("Subscribed Users");
    /**
     *  data of request notification
     */
    @JsonProperty("data")
    private HashMap<String, Map<String,String>> data= new HashMap<>();
    /**
     *  contents to map to  notification
     *  Key should be language short cut  example "en"
     */
    @JsonProperty("contents")
    private Map<String,String> contents =new HashMap<>();
    /**
     *  Set image for the notification
     */
    @JsonProperty("chrome_web_icon")
    private String chromeWebIcon;

}
