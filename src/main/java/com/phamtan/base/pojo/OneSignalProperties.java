package com.phamtan.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * The type One signal properties.
 *
 * @Author Pham Minh Tan binding one signal properties from application.properties
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OneSignalProperties {
    /**
     *  App id which is provided by onesignal (ONESIGNAL APP ID_)
     */

    @NotBlank
    private String appId;

    /**
     *  Secret Key  which is provided by onesignal (REST API KEY)
     */

    @NotBlank
    private String secretKey;

    /**
     *  Url for the one signal
     *  Default using https://onesignal.com/api/v1/notifications
     */
    @NotBlank
    private  String url="https://onesignal.com/api/v1/notifications";

}
