package com.phamtan.base.onesingnal.service;

import com.phamtan.base.helper.CallApiUtil;
import com.phamtan.base.onesingnal.inout.request.NotificationRequest;
import com.phamtan.base.pojo.OneSignalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

/**
 * Use for contact with onesignal server
 * @author phamtan
 */
@Service
public class OneSignalService {
    @Autowired
    private OneSignalProperties oneSignalProperties;
    @Autowired
    private CallApiUtil<NotificationRequest> callApiUtil;

    /**
     * Create notify. only for web push
     *
     * @throws URISyntaxException the uri syntax exception
     */
    public void createNotify(NotificationRequest notificationRequest) throws URISyntaxException {
        callApiUtil.callPostMethodApi(oneSignalProperties.getUrl(),notificationRequest);
    }
}
