package com.example.demo.aopdemo;

import com.example.demo.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService theFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain Program: AroundDemoApp");
        System.out.println("Calling getFortune");
        String data = theFortuneService.getFortune(true);
        System.out.println("\nMy fortune is: " + data);
        System.out.println("Finished");

        context.close();
    }
}
