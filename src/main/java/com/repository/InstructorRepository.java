package com.repository;

import com.model.Instructor;

import java.util.List;

public interface InstructorRepository {

    void saveInstructor(Long id,Instructor instructor);

    void updateInstructor(Long id, Instructor instructor);
    List<Instructor> getInstructorsByCourseId(Long id);

    void deleteInstructor(Long id);

    List<Instructor> getInstructors();

    Instructor getInstructorById(Long id);

    void getStudentsCount();

    void assignedInstructorToCourse(Long instructorId, Long courseId);
}
