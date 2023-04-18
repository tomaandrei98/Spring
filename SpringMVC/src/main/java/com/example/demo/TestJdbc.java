package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
    public static void main(String[] args) {
        try {
            String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker";
            String user = "springstudent";
            String password = "springstudent";

            System.out.println("Connecting to database: " + jdbcUrl);
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
