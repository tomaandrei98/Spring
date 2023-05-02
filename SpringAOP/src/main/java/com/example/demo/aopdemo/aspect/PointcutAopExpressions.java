package com.example.demo.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutAopExpressions {
    @Pointcut("execution(* com.example.demo.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {
    }

    @Pointcut("execution(* com.example.demo.aopdemo.dao.*.get*(..))")
    public void getter() {
    }

    @Pointcut("execution(* com.example.demo.aopdemo.dao.*.set*(..))")
    public void setter() {
    }

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNotGetterAndSetter() {
    }
}