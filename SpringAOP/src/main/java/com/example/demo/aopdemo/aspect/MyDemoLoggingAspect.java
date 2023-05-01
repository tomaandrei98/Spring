package com.example.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    @Pointcut("execution(* com.example.demo.aopdemo.dao.*.*(..))")
    private void forDaoPackage() { }

    @Pointcut("execution(* com.example.demo.aopdemo.dao.*.get*(..))")
    private void getter() { }

    @Pointcut("execution(* com.example.demo.aopdemo.dao.*.set*(..))")
    private void setter() { }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNotGetterAndSetter() { }

    //    @Before("execution(public void com.example.demo.aopdemo.dao.AccountDAO.addAccount())")
    //    @Before("execution(public void add*())")
    //    @Before("execution(void addAccount())")
    //    @Before("execution(public * addAccount())")
    //    @Before("execution(public void addAccount())")
    //    @Before("execution(* add*(com.example.demo.aopdemo.Account))")
    //    @Before("execution(* add*(com.example.demo.aopdemo.Account, ..))")
    //    @Before("execution(* add*(..))")
    //    @Before("execution(* com.example.demo.aopdemo.dao.*.*(..))")
    @Before("forDaoPackageNotGetterAndSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=====>>> Executing @Before advice on method addAccount()");
    }

    @Before("forDaoPackageNotGetterAndSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=====>>> Performing API analytics");
    }
}
