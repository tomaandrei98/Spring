package com.example.demo.mappings.onetoone.onedirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();

            session.beginTransaction();

            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);

            System.out.println("Found instructor: " + tempInstructor);

            if (tempInstructor != null) {
                System.out.println("Deleting: " + tempInstructor);
                session.remove(tempInstructor);
            }

            session.getTransaction().commit();
            System.out.println("Done");
        }
    }
}
