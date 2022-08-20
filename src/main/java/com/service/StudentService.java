package com.service;

import com.model.Student;
import com.repository.StudentRepository;
import com.repositoryImpl.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentService implements StudentRepository {
    private final StudentRepositoryImpl studentRepository;

    @Autowired
    public StudentService(StudentRepositoryImpl studentRepository) {
        this.studentRepository = studentRepository;
    }


    public void saveStudent(Student student) {
        studentRepository.saveStudent(student);
    }


    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }


    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }


    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }
}
