package com.christian.map.hibernate.demo;

import com.christian.map.hibernate.demo.entity.Instructor;
import com.christian.map.hibernate.demo.entity.Student;
import com.christian.map.hibernate.demo.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateUserStudentInstructorDemo {
    public static void main (String[]args){
        //create session factory
        SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student.class)
                .addAnnotatedClass(Instructor.class)
                .buildSessionFactory();
        //create session
        Session session= factory.getCurrentSession();


        try{

            //create the object
            Student tempStudent = new Student("John","Doe","john@doe.com","ENG101");
            Instructor tempInstructor= new Instructor("Mary","Sue","mary@sue.com",20000.00);

            //start a transaction
            session.beginTransaction();

            System.out.println("Saving student and Instructor");

            session.save(tempStudent);
            session.save(tempInstructor);

            //commit the transaction
            session.getTransaction().commit();
            System.out.println("Done");

        }finally{
            //clean up the code
            session.close();
            factory.close();
        }

    }
}
