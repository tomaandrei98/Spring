package com.example.demo.aopdemo.dao;

import com.example.demo.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAOAfterReturning {
    private String name;
    private String level;

    public AccountDAOAfterReturning() {
    }

    public AccountDAOAfterReturning(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public List<Account> findAccounts(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("No soup for you!");
        }

        List<Account> myAccounts = new ArrayList<>();

        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "Platinum");
        Account temp3 = new Account("Luca", "Gold");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADD ACCOUNT");
    }

    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getLevel() {
        System.out.println(getClass() + ": in getServiceCode()");
        return level;
    }

    public void setLevel(String level) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.level = level;
    }

    @Override
    public String toString() {
        return "AccountDAO{" +
                "name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
