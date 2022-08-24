package com.serviceImp;

import com.model.Course;
import com.repository.CourseRepository;
import com.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void saveCourse(Course course, Long id) {
        courseRepository.saveCourse(course,id);
    }

    @Override
    public void updateCourse(Long id,Course course) {
        courseRepository.updateCourse(id, course);
    }


    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteCourse(id);
    }

    @Override
    public List<Course> getAllCourses(Long companyId) {
        return courseRepository.courses(companyId);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public List<Course> getCourses() {
        return courseRepository.getCourses();
    }
}

