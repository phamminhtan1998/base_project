package com.phamtan.base.email.request;

import com.phamtan.base.email.data_structure.EmailContentData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * Define properties for Email Request
 * @author Pham Minh Tan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailRequest {
    /**
     * @param who will receive email
     */
    private String to ;
    /**
     * @param who  send email
     */
    private String from ;
    /**
     * @param subject for email
     */
    private String subject;

    /**
     * @param content of email  will receive email
     */
    private List<EmailContentData> content ;


}
