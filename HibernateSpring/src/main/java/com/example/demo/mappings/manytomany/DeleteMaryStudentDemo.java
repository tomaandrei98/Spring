package com.example.demo.mappings.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMaryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try (factory) {
            session.beginTransaction();

            int courseId = 2;
            Student tempStudent = session.get(Student.class, courseId);

            System.out.println();
            System.out.println("Deleting Student: " + tempStudent);
            session.remove(tempStudent);
            System.out.println();

            session.getTransaction().commit();
        }
    }
}
