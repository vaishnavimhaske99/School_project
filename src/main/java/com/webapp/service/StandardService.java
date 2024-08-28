package com.webapp.service;

import com.webapp.exception.ResourceNotFoundException;
import com.webapp.model.Standard;
import com.webapp.repository.StandardRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandardService {

    @Autowired
    private StandardRepository standardRepository;

    public Standard saveStandard(Standard standard) {
        return standardRepository.save(standard);
    }

    public Standard getStandardById(Long id) {
        return standardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Standard not found with id " + id));
    }

    public Standard updateStandard(Long id, Standard standard) {
        if (!standardRepository.existsById(id)) {
            throw new ResourceNotFoundException("Standard not found with id " + id);
        }
        standard.setId(id);
        return standardRepository.save(standard);
    }

    public void deleteStandard(Long id) {
        if (!standardRepository.existsById(id)) {
            throw new ResourceNotFoundException("Standard not found with id " + id);
        }
        standardRepository.deleteById(id);
    }
}

