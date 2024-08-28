package com.webapp.service;

import com.webapp.model.Teacher;
import com.webapp.repository.TeacherRepository;
import com.webapp.exception.ResourceNotFoundException; // Ensure this import is correct
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private static final Logger logger = LoggerFactory.getLogger(TeacherService.class);

    @Autowired
    private TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher) {
        logger.info("Saving teacher: {}", teacher);
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacherById(Long id) {
        logger.info("Fetching teacher with id: {}", id);
        return teacherRepository.findById(id)
                .orElseThrow(() -> {
                    logger.error("Teacher not found with id: {}", id);
                    return new ResourceNotFoundException("Teacher not found with id " + id);
                });
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {
        if (!teacherRepository.existsById(id)) {
            logger.error("Teacher not found with id: {}", id);
            throw new ResourceNotFoundException("Teacher not found with id " + id);
        }
        teacher.setId(id);
        logger.info("Updating teacher with id: {}", id);
        return teacherRepository.save(teacher);
    }

    public void deleteTeacher(Long id) {
        if (!teacherRepository.existsById(id)) {
            logger.error("Teacher not found with id: {}", id);
            throw new ResourceNotFoundException("Teacher not found with id " + id);
        }
        logger.info("Deleting teacher with id: {}", id);
        teacherRepository.deleteById(id);
    }
}
