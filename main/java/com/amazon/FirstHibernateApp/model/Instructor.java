package com.amazon.FirstHibernateApp.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="instructor")
public class Instructor {

    @Id
    @Column(name="id")
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    // TIP: Here Join colums tells that column instructor_detail_id shoudl reference primary key instructor_detail table
    //
    // But tha actual refercces are done by sql scripts we already ran earlier.
    // Here instructor_detail_id is actuallu referenced to primary key in instructor detail columm via scripts
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")/// instructor_detail_id IS COLUMN NAME IN INSTRUCTOR CLASS
    @Getter @Setter
    private InstructorDetail instructorDetail;


    public Instructor()
    {

    }

    /** REMEMBER DONT PASS ID AS IT IS AUTOINCREMENTED BY OUR SQL SCRIPTS*/
    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }
}
