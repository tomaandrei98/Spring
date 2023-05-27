package com.example.demo.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            Student theStudent =
                    mapper.readValue(new File("demo/src/main/resources/sample-lite.json"), Student.class);
            System.out.println("theStudent: " + theStudent);

            Student secondStudent =
                    mapper.readValue(new File("demo/src/main/resources/sample-full.json"), Student.class);
            System.out.println("secondStudent: " + secondStudent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
