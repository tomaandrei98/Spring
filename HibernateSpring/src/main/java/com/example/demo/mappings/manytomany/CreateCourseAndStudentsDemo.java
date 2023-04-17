package com.example.demo.mappings.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {
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

            Course tempCourse = new Course("Pacman");

            System.out.println("Saving the course..");
            session.persist(tempCourse);
            System.out.println("Saved the course:" + tempCourse);

            Student tempStudent1 = new Student("John", "Doe", "john@gmail.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@gmail.com");

            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            System.out.println("Saving students.. ");
            session.persist(tempStudent1);
            session.persist(tempStudent2);
            System.out.println("Saved students.. " + tempCourse.getStudents());

            session.getTransaction().commit();
        }
    }
}
