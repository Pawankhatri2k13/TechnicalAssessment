package org.example.entity;

import org.beanio.annotation.Field;

public class HeaderRecord {
    @Field(at = 1, length = 1)
    public String recordType = "H";

    @Field(at = 14, length = 15)
    public String fileType = "FLAT_FILE";
}