package com.repository;

import com.model.Student;

import java.util.List;

public interface StudentRepository {
    void saveStudent(Student student,Long id);

    void updateStudent( Student student);

    void deleteStudent(Long id);

    List<Student> getStudents(Long courseId);

    Student getStudentById(Long id);

}
