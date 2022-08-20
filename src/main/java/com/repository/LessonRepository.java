package com.repository;

import com.model.Lesson;

import java.util.List;

public interface LessonRepository {

    void saveLesson(Lesson lesson);

    void updateLesson( Lesson lesson);

    void deleteLesson(Long id);

    List<Lesson> getLessons();

    Lesson getLessonById(Long id);

}
