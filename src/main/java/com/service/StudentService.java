package com.service;

import com.model.Student;

import java.util.List;

public interface StudentService {

    void saveStudent(Student student, Long id);

    void updateStudent( Student student);

    void deleteStudent(Long id);

    List<Student> getStudents(Long id);

    Student getStudentById(Long id);
}
