package com.amazon.FirstHibernateApp.demo;

import com.amazon.FirstHibernateApp.model.Instructor;
import com.amazon.FirstHibernateApp.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateOnetoOneCascadeDemo {

    public static void main(String[] args) {


        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();


        try{

            /**
             * Follwoing first 2 cases gives one directional mapping . Meaining if we delete or perform any operation on
             * instructor it will affect instructor detail but not other way round
             * */

            //create the objects
            Instructor instructor = new Instructor("Chad","Darby","darby@gmail.com");
            InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com","music");

            Instructor instructor1 = new Instructor("Lebron","James","lebron@gmail.com");
            InstructorDetail instructorDetail1 = new InstructorDetail("http://youtube.com","basketball");


            //assosciate the objects
            instructor.setInstructorDetail(instructorDetail);
            instructor1.setInstructorDetail(instructorDetail1);

            //start the transaction
            session.beginTransaction();

            /**
             * Case 1: Create object by cascade operation
             * */
            ///save instructor
            // NOTE: This will also save intructor detial objects because we have mentioned Cascade type in our class
            //Hence all transaction assosciated with Instructor will also have effect on instructor detail

            System.out.println("Saving Instructor!!"+instructor);
            session.save(instructor);
            System.out.println("Saving Instructor 1!!"+instructor1);
            session.save(instructor1);
//            session.getTransaction().commit();


            /**
             * Case 2: Delete Transcation by cascade operation
             * We can similaryly perform update and get similar to videos from normal mapping which means on one table
             * */

            //start the transaction
//            session.beginTransaction();
            int theid = 1;
            Instructor tempInstructor = session.get(Instructor.class,theid);

            System.out.println("Deleting Instructor!!"+tempInstructor);

            if(tempInstructor!= null)
            {
                session.delete(tempInstructor);
            }

            //commit the transaction
            session.getTransaction().commit();


            System.out.println("Done!!!");

        }
        finally {
            session.close();
            factory.close();

        }

    }
}
