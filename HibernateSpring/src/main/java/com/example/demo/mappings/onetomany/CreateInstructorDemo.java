package com.example.demo.mappings.onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try (factory) {
            Instructor tempInstructor = new Instructor("Toma", "Andrei", "tomaandrei98@gmail.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Java");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            session.persist(tempInstructor);

            session.getTransaction().commit();
        }
    }
}
