package com.example.demo.crud.read;

import com.example.demo.entity.Student;
import com.example.demo.util.DateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.text.ParseException;

public class ReadStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new student object");
            Student tempStudent = new Student("Daffy",
                    "Duck",
                    "dd@gmail.com",
                    DateUtils.parseDate("14/4/2002"));

            session.beginTransaction();

            System.out.println("Saving the student..");
            System.out.println(tempStudent);
            session.persist(tempStudent);

            session.getTransaction().commit();

            System.out.println("Saved student. Generated id: " + tempStudent.getId());

            session = factory.getCurrentSession();
            session.beginTransaction();

            Student myStudent = session.get(Student.class, tempStudent.getId());
            System.out.println("Get complete: " + myStudent);

            session.getTransaction().commit();

            System.out.println("Done");
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
