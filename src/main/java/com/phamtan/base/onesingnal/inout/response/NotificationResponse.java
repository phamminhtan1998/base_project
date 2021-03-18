package com.phamtan.base.onesingnal.inout.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class NotificationResponse {
    @JsonProperty("id")
    private String id ;
    @JsonProperty("recipients")
    private String recipients;
}
