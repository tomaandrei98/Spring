package com.example.demo.crud.read;

import com.example.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();

            List<Student> theStudents = session.createQuery("from Student", Student.class).getResultList();
            theStudents.forEach(System.out::println);

            theStudents = session.createQuery("from Student s where s.lastName = 'Doe'", Student.class).getResultList();
            theStudents.forEach(System.out::println);

            theStudents = session.createQuery(
                    "from Student s where s.lastName = 'Doe' OR firstName = 'Daffy'",
                    Student.class).getResultList();
            theStudents.forEach(System.out::println);

            theStudents = session.createQuery(
                    "from Student s where s.email LIKE '%.com'",
                    Student.class).getResultList();
            theStudents.forEach(System.out::println);

            session.getTransaction().commit();

            System.out.println("Done");
        }
    }
}
