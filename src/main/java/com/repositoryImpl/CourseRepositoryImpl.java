package com.repositoryImpl;
import com.model.Course;
import com.repository.CourseRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class CourseRepositoryImpl implements CourseRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public void updateCourse(Course course) {
        entityManager.merge(Course.class);
    }

    @Override
    public void deleteCourse(Long id) {
        entityManager.remove(entityManager.find(Course.class,id));
    }

    @Override
    public List<Course> courses() {
        return entityManager.createQuery("select c from Course c",
                Course.class).getResultList();
    }

    @Override
    public Course getCourseById(Long id) {
        return entityManager.find(Course.class,id);
    }
}
