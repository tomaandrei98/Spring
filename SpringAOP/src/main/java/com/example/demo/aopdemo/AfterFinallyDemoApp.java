package com.example.demo.aopdemo;

import com.example.demo.aopdemo.dao.AccountDAOAfterReturning;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAOAfterReturning theAccountDAO =
                context.getBean("accountDAOAfterReturning", AccountDAOAfterReturning.class);
        List<Account> accounts = null;

        try {
            accounts = theAccountDAO.findAccounts(false);
        } catch (Exception e) {
            System.out.println("\n\nMain Program .. caught exception: " + e.getMessage());
        }

        System.out.println("\n\nMain Program: AfterThrowingDemoApp");
        System.out.println(accounts);

        context.close();
    }
}
