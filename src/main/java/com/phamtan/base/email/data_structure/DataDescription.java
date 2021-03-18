package com.phamtan.base.email.data_structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data description properties for FILE ,TEXT ,IMAGE;
 * @author pham minh tan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataDescription {
    /**
     * Name properties  for value will render by freemarker with template
     * Need exactly match with properties in template file
     */
    private String name;
    /**
     * Data for the value replace to value
     */
    private String data;
}
