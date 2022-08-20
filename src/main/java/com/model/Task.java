package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "getTasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "task_name")
    @SequenceGenerator(name = "task_seq",sequenceName = "task_seq",allocationSize = 1)
    private Long id;
    @Column(name = "task_name")
    private String taskName;
    @Column(name = "task_text",length = 20000)
    private String taskText;
    private LocalDate deadline;

    //VI - Тапшырма бир гана сабака тиешелуу болот

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskText='" + taskText + '\'' +
                ", deadline=" + deadline +
                '}';
    }
}
