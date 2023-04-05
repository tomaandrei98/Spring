package org.example.annotation.inversioncontrolanddependencyinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotation/applicationContext.xml");

//        Coach theCoach = context.getBean("thatSillyCoach", Coach.class);
        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        System.out.println(theCoach.getDailyWorkout());
        System.out.println(theCoach.getDailyFortune());

        context.close();
    }
}
