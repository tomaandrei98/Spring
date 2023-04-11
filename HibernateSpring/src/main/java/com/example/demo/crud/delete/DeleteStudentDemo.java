package com.example.demo.crud.delete;

import com.example.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try (Session session = factory.getCurrentSession()) {
            int studentId = 1;
            session.beginTransaction();

            System.out.println("Getting student with id: " + studentId);
            Student myStudent = session.get(Student.class, studentId);

            System.out.println("Deleting student..");
            session.remove(myStudent);

            System.out.println("Deleting student id = 2");
            session.createQuery("delete from Student where id = 2").executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done");
        }
    }
}
