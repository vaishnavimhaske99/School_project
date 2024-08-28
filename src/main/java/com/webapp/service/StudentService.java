package com.webapp.service;

import com.webapp.model.Standard;
import com.webapp.model.Student;
import com.webapp.repository.StandardRepository;
import com.webapp.repository.StudentRepository;
import com.webapp.exception.ResourceNotFoundException; // Ensure this import is correct

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StandardRepository standardRepository;
    
    public Student saveStudent(Student student) {
        // Fetch the full Standard entity using the provided id
        Standard standard = standardRepository.findById(student.getStandard().getId())
            .orElseThrow(() -> new RuntimeException("Standard not found"));

        // Assign the fetched Standard entity to the student
        student.setStandard(standard);

        // Save the student entity
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        logger.info("Fetching student with id: {}", id);
        return studentRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Student not found with id: {}", id);
                    return new ResourceNotFoundException("Student not found with id " + id);
                });
    }

    public Student updateStudent(Long id, Student student) {
        if (!studentRepository.existsById(id)) {
            logger.error("Student not found with id: {}", id);
            throw new ResourceNotFoundException("Student not found with id " + id);
        }
        student.setId(id);
        logger.info("Updating student with id: {}", id);
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            logger.error("Student not found with id: {}", id);
            throw new ResourceNotFoundException("Student not found with id " + id);
        }
        logger.info("Deleting student with id: {}", id);
        studentRepository.deleteById(id);
    }
}
