package com; // Пакет, в котором находится этот класс

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Ключевая аннотация Spring Boot
public class ExamMvcApplication { // Вы можете выбрать другое имя, если хотите, например, App

    public static void main(String[] args) {
        SpringApplication.run(ExamMvcApplication.class, args);
    }
}