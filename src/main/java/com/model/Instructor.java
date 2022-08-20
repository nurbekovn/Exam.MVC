package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "getInstructors")
@Getter
@Setter
@NoArgsConstructor

public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "instructor_gen")
    @SequenceGenerator(name = "instructor_seq",sequenceName = "instructor_seq",allocationSize = 1)
    private Long id;
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private int phoneNumber;
    private String email;
    private String specialization;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable
    private List<Course> courses;

    public void addCourse(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
    }

    //IV - Бир инструктор бир канча курска сабак ото алат

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
