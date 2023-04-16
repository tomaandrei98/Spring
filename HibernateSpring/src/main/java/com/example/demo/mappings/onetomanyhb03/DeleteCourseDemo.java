package com.example.demo.mappings.onetomanyhb03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try (factory) {
            session.beginTransaction();

            int theId = 10;
            Course tempCourse = session.get(Course.class, theId);
            System.out.println(tempCourse);

            session.remove(tempCourse);

            session.getTransaction().commit();
        }
    }
}
