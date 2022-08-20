package com.repositoryImpl;

import com.model.Student;
import com.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentRepositoryImpl  implements StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void updateStudent(Student student) {
        entityManager.merge(Student.class);
    }

    @Override
    public void deleteStudent(Long id) {
        entityManager.remove(entityManager.find(Student.class,id));
    }

    @Override
    public List<Student> getStudents() {
        return entityManager.createQuery("select s from Student s",
                Student.class).getResultList();
    }

    @Override
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class,id);
    }
}
