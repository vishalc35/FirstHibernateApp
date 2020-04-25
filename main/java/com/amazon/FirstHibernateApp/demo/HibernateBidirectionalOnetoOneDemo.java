package com.amazon.FirstHibernateApp.demo;

import com.amazon.FirstHibernateApp.model.Instructor;
import com.amazon.FirstHibernateApp.model.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateBidirectionalOnetoOneDemo {


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

            session.beginTransaction();

            int theid = 4;
            // creatre InstructorDetail objects
            InstructorDetail instructorDetail = session.get(InstructorDetail.class,theid);

            System.out.println("Printing Instruction detail"+instructorDetail);
            System.out.println("Printing Instruction "+instructorDetail.getInstructor());

            //start the transaction

            session.getTransaction().commit();

            /**
             * Case 2: Delete Transcation by cascade operation
             * We can similaryly perform update and get similar to videos from normal mapping which means on one table
             * */

//            //start the transaction
////            session.beginTransaction();
//            int theid2 = 4;
//            Instructor tempInstructor = session.get(Instructor.class,theid);
//
//            System.out.println("Deleting Instructor!!"+tempInstructor);
//
//            if(tempInstructor!= null)
//            {
//                session.delete(tempInstructor);
//            }
//
//            //commit the transaction
//            session.getTransaction().commit();


            System.out.println("Done!!!");

        }
        finally {
            session.close();
            factory.close();

        }

    }
}
