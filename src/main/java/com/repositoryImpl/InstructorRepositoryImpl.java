package com.repositoryImpl;

import com.model.Course;
import com.model.Instructor;
import com.repository.InstructorRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class InstructorRepositoryImpl implements InstructorRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveInstructor(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(Instructor.class);
    }

    @Override
    public void deleteInstructor(Long id) {
        entityManager.remove(entityManager.find(Instructor.class,id));
    }

    @Override
    public List<Instructor> getInstructors() {
        return entityManager.createQuery("select i from Instructor i",
                Instructor.class).getResultList();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    public void getStudentsCount() {

    }

    @Override
    public void assignedInstructorToCourse(Long instructorId, Long courseId) {
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        Course course = entityManager.find(Course.class, courseId);
        instructor.addCourse(course);
        course.addInstructor(instructor);
        entityManager.merge(course);
        entityManager.merge(instructor);
    }
}