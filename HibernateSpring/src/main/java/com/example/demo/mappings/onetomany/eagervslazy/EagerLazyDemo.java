package com.example.demo.mappings.onetomany.eagervslazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EagerLazyDemo {
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

            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);
            System.out.println("luv2code: Current instructor:" + tempInstructor);

            List<Course> courses = tempInstructor.getCourses();
            System.out.println("luv2code: Courses: " + courses);

            session.getTransaction().commit();
            session.close();

            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
        }
    }
}
