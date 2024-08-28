package com.webapp.service;

import com.webapp.model.Standard;
import com.webapp.model.Subject;
import com.webapp.model.Teacher;
import com.webapp.repository.StandardRepository;
import com.webapp.repository.SubjectRepository;
import com.webapp.repository.TeacherRepository;
import com.webapp.exception.ResourceNotFoundException; // Ensure this import is correct
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StandardRepository standardRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    public Subject saveSubject(Subject subject) {
        if (subject.getStandard() != null) {
            Standard standard = standardRepository.findById(subject.getStandard().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Standard not found with id " + subject.getStandard().getId()));
            subject.setStandard(standard);
        }
        if (subject.getTeacher() != null) {
            Teacher teacher = teacherRepository.findById(subject.getTeacher().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id " + subject.getTeacher().getId()));
            subject.setTeacher(teacher);
        }
        return subjectRepository.save(subject);
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with id " + id));
    }

    public Subject updateSubject(Long id, Subject subject) {
        if (!subjectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Subject not found with id " + id);
        }
        subject.setId(id); // Ensure the ID is set before saving
        if (subject.getStandard() != null) {
            Standard standard = standardRepository.findById(subject.getStandard().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Standard not found with id " + subject.getStandard().getId()));
            subject.setStandard(standard);
        }
        if (subject.getTeacher() != null) {
            Teacher teacher = teacherRepository.findById(subject.getTeacher().getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Teacher not found with id " + subject.getTeacher().getId()));
            subject.setTeacher(teacher);
        }
        return subjectRepository.save(subject);
    }

    public void deleteSubject(Long id) {
        if (!subjectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Subject not found with id " + id);
        }
        subjectRepository.deleteById(id);
    }
}
