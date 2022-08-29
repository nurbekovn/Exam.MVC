package com.repository;

import com.model.Course;

import java.util.List;

public interface CourseRepository {
    void saveCourse(Course course,Long id);

    void updateCourse(Long id, Course course);
    void deleteCourse(Long id);
    List<Course> courses(Long companyId);
    Course getCourseById(Long id);
    List<Course> getCourses();
}
