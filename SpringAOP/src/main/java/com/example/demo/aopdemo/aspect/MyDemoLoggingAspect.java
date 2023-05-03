package com.example.demo.aopdemo.aspect;

import com.example.demo.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    //    @Before("execution(public void com.example.demo.aopdemo.dao.AccountDAO.addAccount())")
    //    @Before("execution(public void add*())")
    //    @Before("execution(void addAccount())")
    //    @Before("execution(public * addAccount())")
    //    @Before("execution(public void addAccount())")
    //    @Before("execution(* add*(com.example.demo.aopdemo.Account))")
    //    @Before("execution(* add*(com.example.demo.aopdemo.Account, ..))")
    //    @Before("execution(* add*(..))")
    //    @Before("execution(* com.example.demo.aopdemo.dao.*.*(..))")
    @Before("com.example.demo.aopdemo.aspect.PointcutAopExpressions.forDaoPackageNotGetterAndSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n=====>>> Executing @Before advice on method addAccount()");

        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method: " + methodSignature);

        for (Object arg : theJoinPoint.getArgs()) {
            System.out.println(arg);

            if (arg instanceof Account theAccount) {
                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }
}
