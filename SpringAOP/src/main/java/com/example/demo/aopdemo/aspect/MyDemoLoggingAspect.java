package com.example.demo.aopdemo.aspect;

import com.example.demo.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
    private Logger myLogger =
            Logger.getLogger(getClass().getName());

    @Around("execution(* com.example.demo.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n=====>>> Executing @Around on method: " + method);

        long begin = System.currentTimeMillis();
        Object result = null;

        try {
            result = theProceedingJoinPoint.proceed();
        } catch (RuntimeException e) {
            myLogger.warning(e.getMessage());
            result = "Major accident! But no worries..";
            throw e;
        }

        long end = System.currentTimeMillis();
        long duration = end - begin;
        myLogger.info("\n=====>> Duration: " + duration / 1_000.0 + " seconds");

        return result;
    }

    @After("execution(* com.example.demo.aopdemo.dao.AccountDAOAfterReturning.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
        String method = theJoinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @After (finally) on method: " + method);
    }

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

    @AfterReturning(
            pointcut = "execution(* com.example.demo.aopdemo.dao.AccountDAOAfterReturning.findAccounts(..))",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterReturning on method: " + method);

        System.out.println("\n=====>>> result is: " + result);
        convertAccountNamesToUpperCase(result);

        System.out.println("\n=====>>> result is: " + result);
    }

    @AfterThrowing(
            pointcut = "execution(* com.example.demo.aopdemo.dao.AccountDAOAfterReturning.findAccounts(..))",
            throwing = "theExc")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable theExc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n=====>>> Executing @AfterThrowing on method: " + method);

        System.out.println("\n=====>>> exception is: " + theExc);
    }

    private void convertAccountNamesToUpperCase(List<Account> result) {
        result.forEach(account -> account.setName(account.getName().toUpperCase()));
    }
}
