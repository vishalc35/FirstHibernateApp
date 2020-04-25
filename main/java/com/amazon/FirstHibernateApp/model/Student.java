package com.amazon.FirstHibernateApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    @Column(name="id")
    @Getter @Setter
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

    public Student(int id,String firstName, String lastName, String email) {
        this.id = id;
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
