package com.example.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    //    @Before("execution(public void com.example.demo.aopdemo.dao.AccountDAO.addAccount())")
    //    @Before("execution(public void add*())")
    //    @Before("execution(void addAccount())")
    //    @Before("execution(public * addAccount())")
    //    @Before("execution(public void addAccount())")
    //    @Before("execution(* add*(com.example.demo.aopdemo.Account))")
    //    @Before("execution(* add*(com.example.demo.aopdemo.Account, ..))")
    //    @Before("execution(* add*(..))")
    @Before("execution(* com.example.demo.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method addAccount()");
    }
}
