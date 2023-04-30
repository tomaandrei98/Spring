package com.example.demo.aopdemo;

import com.example.demo.aopdemo.dao.AccountDAO;
import com.example.demo.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        theAccountDAO.addAccount(new Account(), true);
        theAccountDAO.doWork();
        theMembershipDAO.addAccount();
        theMembershipDAO.goToSleep();

        context.close();
    }
}
