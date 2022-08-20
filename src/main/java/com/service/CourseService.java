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
public class CourseService implements CourseRepository {

    private final CourseRepositoryImpl courseRepository;

    @Autowired
    public CourseService(CourseRepositoryImpl courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.saveCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.updateCourse(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteCourse(id);
    }

    @Override
    public List<Course> courses() {
        return courseRepository.courses();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }
}
