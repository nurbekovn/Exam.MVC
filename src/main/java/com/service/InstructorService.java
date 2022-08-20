package com.service;

import com.model.Instructor;
import com.repository.InstructorRepository;
import com.repositoryImpl.InstructorRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InstructorService {

    private final InstructorRepositoryImpl instructorRepository;

    @Autowired
    public InstructorService(InstructorRepositoryImpl instructorRepository) {
        this.instructorRepository = instructorRepository;
    }


    public void saveInstructor(Instructor instructor) {
        instructorRepository.saveInstructor(instructor);
    }


    public void updateInstructor(Instructor instructor) {
        instructorRepository.updateInstructor(instructor);
    }


    public void deleteInstructor(Long id) {
        instructorRepository.deleteInstructor(id);
    }


    public List<Instructor> getInstructors() {
        return instructorRepository.getInstructors();
    }


    public Instructor getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id);
    }


    public void getStudentsCount() {

    }


    public void assignedInstructorToCourse(Long instructorId, Long courseId) {
        instructorRepository.assignedInstructorToCourse(instructorId,courseId);
    }
}
