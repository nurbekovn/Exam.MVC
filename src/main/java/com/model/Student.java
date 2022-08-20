package com.model;

import com.enums.Study;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "getStudents")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_name")
    @SequenceGenerator(name = "student_seq", sequenceName = "student_seq", allocationSize = 1)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_number")
    private int phoneNumber;
    private String email;
    private Study studyFormat;

//III - Студенттер бир гана курс ала алат

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    private Course course;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                '}';
    }
}
