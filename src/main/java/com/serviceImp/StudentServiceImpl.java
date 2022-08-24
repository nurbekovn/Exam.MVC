package com.serviceImp;

import com.model.Student;
import com.repository.StudentRepository;
import com.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public void saveStudent(Student student, Long id) {
        studentRepository.saveStudent(student,id);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteStudent(id);
    }

    @Override
    public List<Student> getStudents(Long id) {
        return studentRepository.getStudents(id);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }
}
