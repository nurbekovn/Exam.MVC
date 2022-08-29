package com.repository;

import com.model.Lesson;

import java.util.List;

public interface LessonRepository {

    void saveLesson(Long courseId,Lesson lesson);

    void updateLesson(Long id, Lesson lesson);

    void deleteLesson(Long id);

    List<Lesson> getLessons(Long courseId);

    Lesson getLessonById(Long id);

}
