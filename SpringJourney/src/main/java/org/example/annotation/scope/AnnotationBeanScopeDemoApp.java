package org.example.annotation.scope;

import org.example.annotation.inversioncontrolanddependencyinjection.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("annotation/applicationContext.xml");

        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach alphaCoach = context.getBean("tennisCoach", Coach.class);

        System.out.println("pointing to the same obj: " + (theCoach == alphaCoach));
        System.out.println("memory location for theCoach: " + theCoach);
        System.out.println("memory location for alphaCoach: " + alphaCoach);

        context.close();
    }
}
