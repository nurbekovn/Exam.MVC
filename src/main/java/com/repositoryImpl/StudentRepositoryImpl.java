package com.repositoryImpl;

import com.model.Course;
import com.model.Student;
import com.repository.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveStudent(Student student, Long courseId) {
        Course course = entityManager.find(Course.class, courseId);
        course.addStudent(student);
        student.setCourse(course);
        entityManager.merge(student);
    }

    @Override
    public void updateStudent(Student student) {
        entityManager.merge(Student.class);
    }

    @Override
    public void deleteStudent(Long id) {
        entityManager.remove(entityManager.find(Student.class, id));
    }

    @Override
    public List<Student> getStudents(Long courseId) {
        return entityManager.createQuery("select s from Student s where " +
                        "s.course.id=:courseId",
                Student.class).setParameter("courseId",courseId).getResultList();
    }


    @Override
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }
}
