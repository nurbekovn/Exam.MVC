package com.service;

import com.model.Lesson;
import com.repository.LessonRepository;
import com.repositoryImpl.LessonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LessonService {

    private final LessonRepositoryImpl lessonRepository;

    @Autowired
    public LessonService(LessonRepositoryImpl lessonRepository) {
        this.lessonRepository = lessonRepository;
    }



    public void saveLesson(Lesson lesson) {
        lessonRepository.saveLesson(lesson);
    }


    public void updateLesson(Lesson lesson) {
        lessonRepository.updateLesson(lesson);
    }


    public void deleteLesson(Long id) {
        lessonRepository.deleteLesson(id);
    }


    public List<Lesson> getLessons() {
        return lessonRepository.getLessons();
    }


    public Lesson getLessonById(Long id) {
        return lessonRepository.getLessonById(id);
    }
}
