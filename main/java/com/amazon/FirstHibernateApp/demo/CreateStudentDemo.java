package com.amazon.FirstHibernateApp.demo;

import com.amazon.FirstHibernateApp.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

//
// REPEAT ...I REPEAT ...DO NOT DELETE ...JUST UNCOMMENT THE CODE TO UNDERSSTAND
// WE ARE DELTEING BECUASE WE ARE ADDIN MULTIPLE DEMO TO HAVE MAIN CLASS
/**
 * Although this class only has create and read demo, watch other videos from udemy for update and delete
 * Also watch Advanced Hibernate mapping for @OnetoMany concepts
 * **/


public class CreateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {

            /**
             * OPERATION CREATE STUDENT
             * **/

//            System.out.println("Creating new Student object!!!");
//            Student tempStudent1 = new Student("Paul","Smit","paul@gmail.com");
//            Student tempStudent2 = new Student("clinton","jones","clinton@gmail.com");
//            Student tempStudent3 = new Student("lebron","james","lebron@gmail.com");
//
//            session.beginTransaction();
//            System.out.println("Saving Student!!");
//            session.save(tempStudent1);
//            session.save(tempStudent2);
//            session.save(tempStudent3);
//            session.getTransaction().commit();



            /**
             * OPERATION READ STUDENT
             * **/

//            System.out.println("READING Student object!!!");
//            Student tempStudent1 = new Student("Stephen","Curry","Stephen@gmail.com");
//            session.beginTransaction();
//            System.out.println("Saving Student!!");
//            session.save(tempStudent1);
//            session.getTransaction().commit();
//
//
//            session = factory.getCurrentSession();
//            session.beginTransaction();
//            Student myStudent = session.get(Student.class,tempStudent1.getId());
//            session.getTransaction().commit();
//            System.out.println("Get Complete!!--"+ myStudent.getId());

            /**
             * Query using hibernate query language HQL
             * **/

            session = factory.getCurrentSession();
            session.beginTransaction();

            /**
             *
             *Here rememeber from Student "Capital S" is used because we are not using
             * table name directly.we are using class name
             */

            List<Student> students = session.createQuery("from Student").getResultList();

            for (Student student:students) {
                System.out.println("Printing stuedents!!"+ student);
            }

            session.getTransaction().commit();

            System.out.println("Done!!");

        }
        finally {
            factory.close();
        }

    }

}
