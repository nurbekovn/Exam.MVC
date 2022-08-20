package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "getLessons")
@Getter
@Setter
@NoArgsConstructor

public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lesson_name")
    @SequenceGenerator(name = "lesson_seq",sequenceName = "lesson_seq",allocationSize = 1)
    private Long id;
    @Column(name = "lesson_name")
    private String lessonName;
//V - Сабака бир канча тапшырма жана бир видео жуктосо болот

    @OneToOne
    private Video video;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", lessonName='" + lessonName + '\'' +
                ", video=" + video +
                '}';
    }
}
