package com.example.demo.mappings.onetomany.eagervslazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class FetchJoinDemo {
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
            Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i " +
                    "JOIN FETCH i.courses " +
                    "WHERE i.id=:theInstructorId", Instructor.class);
            query.setParameter("theInstructorId", theId);

            Instructor tempInstructor = query.getSingleResult();
            System.out.println("luv2code: Instructor: " + tempInstructor);

            session.getTransaction().commit();
            session.close();

            System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
        }
    }
}
