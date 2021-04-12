package com.phamtan.base.helper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.phamtan.base.pojo.OneSignalProperties;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 *  Class to call rest Api
 * @author Pham Minh Tan
 * @param <T>
 */
@Component
public class CallApiUtil<T> {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    OneSignalProperties oneSignalProperties;
    @Autowired
    ObjectMapper objectMapper;
    public String callPostMethodApi(String url, T data) throws URISyntaxException {
        URI uri = new URI(url);
        HttpHeaders headers = getHeaders();
        HttpEntity<T> request = new HttpEntity<T>(data, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
        if(response.getStatusCode()== HttpStatus.OK){
            return "Tọa thông báo thành công";
        }
        else return "Tạo thông báo thất bại";
    }

    public String callGetMethodApi(String url) throws URISyntaxException {
        URI uri = new URI(url);
        HttpHeaders headers = getHeaders();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if(response.getStatusCode()==HttpStatus.OK){
            return response.getBody();
        }
        else{
            return "Không tìm thấy thông báo ";
        }
    }
    public HttpHeaders getHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(oneSignalProperties.getSecretKey());
        return headers;
    }
}
