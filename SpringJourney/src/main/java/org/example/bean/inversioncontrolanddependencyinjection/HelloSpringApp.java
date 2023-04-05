package org.example.bean.inversioncontrolanddependencyinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        // load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean/applicationContext.xml");

        // retrieve bean from spring container
        Coach theCoach = context.getBean("myCoach", Coach.class);

        // call methods on the bean
        System.out.println(theCoach.getDailyWorkout());

        // call new method for fortunes
        System.out.println(theCoach.getDailyFortune());

        // close the context
        context.close();
    }
}
