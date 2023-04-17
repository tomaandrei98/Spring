package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        try {
//            String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker";
//            String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni";
//            String jdbcUrl = "jdbc:mysql://localhost:3306/hb-03-one-to-many";
//            String jdbcUrl = "jdbc:mysql://localhost:3306/hb-04-one-to-many-uni";
            String jdbcUrl = "jdbc:mysql://localhost:3306/hb-05-many-to-many";
            String user = "hbstudent";
            String password = "hbstudent";

            System.out.println("Connecting to database: " + jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
