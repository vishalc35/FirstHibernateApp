package com.amazon.FirstHibernateApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// Use this for refernce https://examples.javacodegeeks.com/enterprise-java/hibernate/hibernate-annotations-example/
// Otherwise use refernec form udemy tutorial

@Entity
@Table(name="student")
public class Student {

    @Id
    @Column(name="id")
    @Getter @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**REMEMBER TO MAKE THE PRIMARY KEY COLUMN TO AUTO INCREMENT**/
    private int id;
    @Column(name="first_name")
    @Getter @Setter
    private String firstName;
    @Column(name="last_name")
    @Getter @Setter
    private String lastName;
    @Column(name="email")
    @Getter @Setter
    private String email;

    public Student()
    {

    }

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
