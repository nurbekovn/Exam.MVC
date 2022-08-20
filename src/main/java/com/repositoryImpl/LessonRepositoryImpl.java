package com.repositoryImpl;

import com.model.Lesson;
import com.repository.LessonRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LessonRepositoryImpl implements LessonRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveLesson(Lesson lesson) {
        entityManager.persist(lesson);
    }

    @Override
    public void updateLesson(Lesson lesson) {
        entityManager.merge(Lesson.class);
    }

    @Override
    public void deleteLesson(Long id) {
        entityManager.remove(entityManager.find(Lesson.class,id));
    }

    @Override
    public List<Lesson> getLessons() {
        return entityManager.createQuery("select l from Lesson  l ",
                Lesson.class).getResultList();
    }

    @Override
    public Lesson getLessonById(Long id) {
        return entityManager.find(Lesson.class,id);
    }
}
