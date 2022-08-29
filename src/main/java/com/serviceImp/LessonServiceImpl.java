package com.serviceImp;

import com.model.Lesson;
import com.repository.LessonRepository;
import com.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonServiceImpl(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
        lessonRepository.saveLesson(courseId,lesson);
    }

    @Override
    public void updateLesson(Long id,Lesson lesson) {
        lessonRepository.updateLesson(id, lesson);
    }

    @Override
    public void deleteLesson(Long id) {
        lessonRepository.deleteLesson(id);
    }

    @Override
    public List<Lesson> getLessons(Long id) {
        return lessonRepository.getLessons(id);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonRepository.getLessonById(id);
    }
}
