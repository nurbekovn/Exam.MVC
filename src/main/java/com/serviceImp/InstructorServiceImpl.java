package com.serviceImp;

import com.model.Instructor;
import com.repository.InstructorRepository;
import com.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public void saveInstructor(Long id,Instructor instructor) {
        instructorRepository.saveInstructor(id,instructor);
    }

    @Override
    public void updateInstructor(Long id,Instructor instructor) {
        instructorRepository.updateInstructor(id, instructor);
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorRepository.deleteInstructor(id);
    }

    @Override
    public List<Instructor> getAllInstructors(Long id) {
        return instructorRepository.getInstructors();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorsByCompanyId(Long id) {
        return instructorRepository.getInstructorsByCompany(id);
    }

    @Override
    public void getStudentsCount() {
        instructorRepository.getStudentsCount();
    }

    @Override
    public void assignedInstructorToCourse(Long instructorId, Long courseId) {
        instructorRepository.assignedInstructorToCourse(instructorId,courseId);
    }
}
