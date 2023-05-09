package com.example.demo.aopdemo;

import com.example.demo.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {
    private static Logger myLogger =
            Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        TrafficFortuneService theFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMain Program: AroundDemoApp");
        myLogger.info("Calling getFortune");
        String data = theFortuneService.getFortune(true);
        myLogger.info("\nMy fortune is: " + data);
        myLogger.info("Finished");

        context.close();
    }
}
