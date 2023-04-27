package com.example.demo.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADD ACCOUNT");
    }
}
