package com.example.demo.mappings.onetoone.onedirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();

//            Instructor tempInstructor = new Instructor("Chad", "Darby", "darby@gmail.com");
//            InstructorDetail tempInstructorDetail =
//                    new InstructorDetail("http://www.google.com", "love to code");
//            tempInstructor.setInstructorDetail(tempInstructorDetail);

            Instructor tempInstructor = new Instructor("Toma", "Andrei", "tomaandrei98@gmail.com");
            InstructorDetail tempInstructorDetail =
                    new InstructorDetail("http://www.youtube.com", "piano");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            System.out.println("Saving instructor: " + tempInstructor);
            session.persist(tempInstructor);

            session.getTransaction().commit();
            System.out.println("Done");
        }
    }
}
