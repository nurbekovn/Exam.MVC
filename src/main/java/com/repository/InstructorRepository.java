package com.repository;

import com.model.Instructor;

import java.util.List;

public interface InstructorRepository {

    void saveInstructor(Instructor instructor);

    void updateInstructor( Instructor instructor);

    void deleteInstructor(Long id);

    List<Instructor> getInstructors();

    Instructor getInstructorById(Long id);

    void getStudentsCount();

    void assignedInstructorToCourse(Long instructorId, Long courseId);
}
