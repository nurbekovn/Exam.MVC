package com.service;

import com.model.Lesson;

import java.util.List;

public interface LessonService {
    void saveLesson(Lesson lesson);

    void updateLesson( Lesson lesson);

    void deleteLesson(Long id);

    List<Lesson> getLessons();

    Lesson getLessonById(Long id);
}
