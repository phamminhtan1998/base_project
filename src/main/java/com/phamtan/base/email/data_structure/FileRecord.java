package com.phamtan.base.email.data_structure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileRecord {
    private String name;
    private File file;
}
