package org.example.entity;

import org.beanio.annotation.Field;
public class TrailerRecord {

    @Field(at = 1, length = 1)
    public String recordType = "T";

    @Field(at = 14, length = 15)
    public String fileType = "FLAT_FILE";

    // Getters and setters
}