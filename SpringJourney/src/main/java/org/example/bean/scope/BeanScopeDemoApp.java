package org.example.bean.scope;

import org.example.bean.inversioncontrolanddependencyinjection.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean/beanScope-applicationContext.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);
        Coach alphaCoach = context.getBean("myCoach", Coach.class);

        System.out.println("pointing to the same object: " + (theCoach == alphaCoach));
        System.out.println("memory location for theCoach: " + theCoach);
        System.out.println("memory location for alphaCoach: " + alphaCoach);
    }
}
