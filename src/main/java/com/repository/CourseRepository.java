package com.repository;

import com.model.Course;

import java.util.List;

public interface CourseRepository {
    void saveCourse(Course course);
    void updateCourse( Course course);
    void deleteCourse(Long id);
    List<Course> courses();
    Course getCourseById(Long id);

}
