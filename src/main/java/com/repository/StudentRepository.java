package com.repository;

import com.model.Student;

import java.util.List;

public interface StudentRepository {
    void saveStudent(Student student);

    void updateStudent( Student student);

    void deleteStudent(Long id);

    List<Student> getStudents();

    Student getStudentById(Long id);

}
