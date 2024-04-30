package org.example;

import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.beanio.builder.StreamBuilder;
import org.example.entity.BodyRecord;
import org.example.entity.HeaderRecord;
import org.example.entity.TrailerRecord;

import java.io.*;

public class FlatFileGenerator {
    public static void main(String[] args) {
        // Created a StreamFactory
        StreamFactory factory = StreamFactory.newInstance();

        // Defined the header format here
        StreamBuilder headerStream = new StreamBuilder("header")
                .format("fixedlength")
                .addRecord(HeaderRecord.class);

        // Defined the body format here
        StreamBuilder bodyStream = new StreamBuilder("body")
                .format("fixedlength")
                .addRecord(BodyRecord.class);

        // Defined the trailer format here
        StreamBuilder trailerStream = new StreamBuilder("trailer")
                .format("fixedlength")
                .addRecord(TrailerRecord.class);

        // Added streams to the factory
        factory.define(headerStream);
        factory.define(bodyStream);
        factory.define(trailerStream);

        // Created a BeanWriter
        BeanWriter out = factory.createWriter("body", new File("TEST.txt"));

        // Write header
        out.write(new HeaderRecord());

        // Write body data
        out.write(createBRecord("4234234244", "RM12.00"));
        out.write(createBRecord("4234243433", "RM8.00"));
        out.write(createBRecord("4534131232", "RM75.00"));

        // Write trailer
        out.write(new TrailerRecord());

        // Close the writer
        out.close();
        System.out.println("Record write successfully.");
    }

    private static BodyRecord createBRecord(String referenceNo, String amount) {
        BodyRecord record = new BodyRecord();
        record.setReferenceNo(referenceNo);
        record.setAmount(amount);
        return record;
    }
}