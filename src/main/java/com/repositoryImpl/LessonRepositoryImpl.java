package com.repositoryImpl;

import com.model.Course;
import com.model.Lesson;
import com.model.Student;
import com.repository.LessonRepository;
import com.service.CourseService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LessonRepositoryImpl implements LessonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    private final CourseService courseService;

    public LessonRepositoryImpl(CourseService courseService) {
        this.courseService = courseService;
    }

    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
        Course course = entityManager.find(Course.class, courseId);
        course.addLesson(lesson);
        lesson.setCourse(course);
        entityManager.persist(course);

    }


    @Override
    public void updateLesson(Long id, Lesson lesson) {
        Lesson lesson1 = entityManager.find(Lesson.class, id);
        lesson1.setLessonName(lesson.getLessonName());
        lesson1.setVideo(lesson.getVideo());
        entityManager.merge(lesson1);
    }

    @Override
    public void deleteLesson(Long id) {
        Lesson lesson = entityManager.find(Lesson.class, id);
        lesson.setCourse(null);
        entityManager.remove(lesson);


    }

    @Override
    public List<Lesson> getLessons(Long courseId) {
        return entityManager.createQuery("select l from Lesson  l where l.course.id=:courseId",
                Lesson.class).setParameter("courseId", courseId).getResultList();
    }

    @Override
    public Lesson getLessonById(Long id) {
        return entityManager.find(Lesson.class, id);
    }
}
