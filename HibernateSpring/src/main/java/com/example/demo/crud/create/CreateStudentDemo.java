package com.example.demo.crud.create;

import com.example.demo.entity.Student;
import com.example.demo.util.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;
import java.util.Date;


public class CreateStudentDemo {
    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session

        try (Session session = factory.getCurrentSession()) {
            System.out.println("Creating new student object");

            String theDateOfBirthStr = "31/12/1998";
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);

            Student tempStudent = new Student("Paul", "Wall", "paulW@gmail.com", theDateOfBirth);

            session.beginTransaction();

            System.out.println("Saving the student..");
            session.persist(tempStudent);

            session.getTransaction().commit();

            System.out.println("Done");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
