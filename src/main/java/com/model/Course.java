package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_name")
    @SequenceGenerator(name = "course_seq",sequenceName = "course_seq",allocationSize = 1)
    private Long id;
    @Column(name = "course_name")
    private String courseName;
    private int duration;
    @Column(length = 20000)
    private String image;
    private String description;
    @ManyToOne(cascade = {MERGE,REFRESH,PERSIST,DETACH})
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "courses")
    private List<Instructor> instructors;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "course")
    private List<Lesson> lessons;

    public void addInstructor(Instructor instructor) {
        if (instructors == null) {
            instructors = new ArrayList<>();
        }
        instructors.add(instructor);
    }


    //II - Бир курста бир канча инструкторлор, студенттер жана сабактар боло алат

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", duration=" + duration +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
