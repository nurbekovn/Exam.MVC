package com.repositoryImpl;

import com.model.Company;
import com.model.Course;
import com.model.Instructor;
import com.repository.InstructorRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class InstructorRepositoryImpl implements InstructorRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveInstructor(Long id, Instructor instructor) {
        Company company = entityManager.find(Company.class, id);
        company.addInstructor(instructor);
        instructor.setCompany(company);
        entityManager.merge(company);
        // merge(company)

    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        Instructor instructor1 = entityManager.find(Instructor.class, id);
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        instructor1.setEmail(instructor.getEmail());
        entityManager.merge(instructor1);
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long id) {
        return entityManager.createQuery("select c from Instructor c where c.company.id=:id",Instructor.class)
                .setParameter("id",id).getResultList();
    }

    @Override
    public void deleteInstructor(Long id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        for (Course c :instructor.getCourses()) {
            c.setInstructors(null);
        }
//        entityManager.remove(entityManager.find(Instructor.class,id));
        entityManager.remove(instructor);
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
    public void assignedInstructorToCourse(Long instructorId, Long courseId) {
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        Course course = entityManager.find(Course.class, courseId);
        instructor.addCourse(course);
        course.addInstructor(instructor);
        entityManager.merge(instructor);
        entityManager.merge(course);
    }

    @Override
    public void getStudentsCount() {

    }
}