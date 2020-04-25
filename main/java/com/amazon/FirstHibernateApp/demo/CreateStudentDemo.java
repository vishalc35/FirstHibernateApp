package com.amazon.FirstHibernateApp.demo;

import com.amazon.FirstHibernateApp.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {

            System.out.println("Creating new Student object!!!");
            Student tempStudent1 = new Student("Paul","Smit","paul@gmail.com");
            Student tempStudent2 = new Student("clinton","jones","clinton@gmail.com");
            Student tempStudent3 = new Student("lebron","james","lebron@gmail.com");

            session.beginTransaction();
            System.out.println("Saving Student!!");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            session.getTransaction().commit();
            System.out.println("Done!!");

        }
        finally {
            factory.close();
        }

    }

}
