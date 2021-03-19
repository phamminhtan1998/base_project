package com.phamtan.base.email.data_structure;

import com.phamtan.base.enumeration.EmailEnum;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class EmailContentData {
    /**
     * Type of Data Email
     */
    private EmailEnum key;
    /**
     * Description for data
     */
    private String name ;
    private String data ;

}
