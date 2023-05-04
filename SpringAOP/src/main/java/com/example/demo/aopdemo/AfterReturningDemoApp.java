package com.example.demo.aopdemo;

import com.example.demo.aopdemo.dao.AccountDAOAfterReturning;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAOAfterReturning theAccountDAO =
                context.getBean("accountDAOAfterReturning", AccountDAOAfterReturning.class);

        List<Account> accounts = theAccountDAO.findAccounts();

        System.out.println("\n\nMain Program: AfterReturningDemoApp");
        System.out.println(accounts);

        context.close();
    }
}
