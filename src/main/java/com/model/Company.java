package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_gen")
    @SequenceGenerator(name = "company_seq", sequenceName = "company_seq", allocationSize = 1)
    private Long id;
    @Column(name = "company_name")
    private String companyName;

    //I -  Бир компанияда бир канча курстар жана студенттер болушу керек

    @Column(name = "located_country")
    private String locatedCountry;

    @OneToMany(cascade = CascadeType.ALL, mappedBy ="company")
    private List<Course> courses;

    @OneToMany(cascade = CascadeType.ALL, mappedBy ="company")
    private List<Student> students;


    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", locatedCountry='" + locatedCountry + '\'' +
                '}';
    }
}
