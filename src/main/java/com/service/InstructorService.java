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
public class InstructorService implements InstructorRepository {

    private final InstructorRepositoryImpl instructorRepository;

    @Autowired
    public InstructorService(InstructorRepositoryImpl instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public void saveInstructor(Instructor instructor) {
        instructorRepository.saveInstructor(instructor);
    }

    @Override
    public void updateInstructor(Instructor instructor) {
        instructorRepository.updateInstructor(instructor);
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorRepository.deleteInstructor(id);
    }

    @Override
    public List<Instructor> getInstructors() {
        return instructorRepository.getInstructors();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public void getStudentsCount() {

    }

    @Override
    public void assignedInstructorToCourse(Long instructorId, Long courseId) {
        instructorRepository.assignedInstructorToCourse(instructorId,courseId);
    }
}
