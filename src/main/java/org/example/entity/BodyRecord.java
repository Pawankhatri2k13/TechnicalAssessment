package org.example.entity;

import org.beanio.annotation.Field;

public class BodyRecord {
    @Field(at = 1, length = 1)
    public String recordType = "B";

    @Field(at = 20, length = 14)
    public String referenceNo;

    @Field(at = 40, length = 16)
    public String amount;
    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
