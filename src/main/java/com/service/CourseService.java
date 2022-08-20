package com.service;

import com.model.Course;
import com.repository.CourseRepository;
import com.repositoryImpl.CourseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CourseService  {

    private final CourseRepositoryImpl courseRepository;

    @Autowired
    public CourseService(CourseRepositoryImpl courseRepository) {
        this.courseRepository = courseRepository;
    }


    public void saveCourse(Course course) {
        courseRepository.saveCourse(course);
    }


    public void updateCourse(Course course) {
        courseRepository.updateCourse(course);
    }


    public void deleteCourse(Long id) {
        courseRepository.deleteCourse(id);
    }


    public List<Course> courses() {
        return courseRepository.courses();
    }


    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }
}
