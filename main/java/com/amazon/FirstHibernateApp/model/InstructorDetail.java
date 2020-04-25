package com.amazon.FirstHibernateApp.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

    @Id
    @Column(name="id")
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="youtube_channel")
    @Getter @Setter
    private String youtubeChannel;

    @Column(name="hobby")
    @Getter @Setter
    private String hobby;


//    /**
//     * For Bi Directional mapping - meaning if we want to make sure that update/delete on instrucor detail should also
//     * affect Instructor then we add the following mapping

    // DO NOT DELETE THE FOLLWOING CODE
//     * */
//
//    //PLEASE NOTE that here instructorDetail refers to field in instructor class
    @OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
    @Getter @Setter
    private Instructor instructor;


    public InstructorDetail()
    {

    }

    /** REMEMBER DONT PASS ID AS IT IS AUTOINCREMENTED BY OUR SQL SCRIPTS*/
//    public InstructorDetail(String youtubeChannel, String hobby) {
//        this.youtubeChannel = youtubeChannel;
//        this.hobby = hobby;
//    }

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }



        @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
