package com.example.demo.mappings.onetoone.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorDetailDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        try (factory) {
            Session session = factory.getCurrentSession();

            session.beginTransaction();

            int theId = 29;
            InstructorDetail tempInstructorDetail =
                    session.get(InstructorDetail.class, theId);

            System.out.println("tempInstructorDetail: " + tempInstructorDetail);
            System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

            session.getTransaction().commit();
            System.out.println("Done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
