package com.example.demo.crud.create;

import com.example.demo.entity.Student;
import com.example.demo.util.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {
            System.out.println("Creating new student object");
            Student tempStudent1 = new Student("John",
                    "Doe",
                    "john@gmail.com",
                    DateUtils.parseDate("20/2/1990"));
            Student tempStudent2 = new Student("Mary",
                    "Public",
                    "mary@gmail.com",
                    DateUtils.parseDate("10/6/1980"));
            Student tempStudent3 = new Student("Bonita",
                    "Applebum",
                    "bonita@gmail.com",
                    DateUtils.parseDate("17/9/1977"));

            session.beginTransaction();

            System.out.println("Saving the student..");
            session.persist(tempStudent1);
            session.persist(tempStudent2);
            session.persist(tempStudent3);

            session.getTransaction().commit();

            System.out.println("Done");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}