package com.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.webapp.model.Standard;
import com.webapp.service.StandardService;


@RestController
@RequestMapping("/standards")
public class StandardController {

    @Autowired
    private StandardService standardService;

    @PostMapping
    public ResponseEntity<Standard> createStandard(@RequestBody Standard standard) {
        Standard savedStandard = standardService.saveStandard(standard);
        return ResponseEntity.ok(savedStandard);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Standard> getStandardById(@PathVariable Long id) {
        Standard standard = standardService.getStandardById(id);
        return ResponseEntity.ok(standard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Standard> updateStandard(@PathVariable Long id, @RequestBody Standard standard) {
        Standard updatedStandard = standardService.updateStandard(id, standard);
        return ResponseEntity.ok(updatedStandard);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStandard(@PathVariable Long id) {
        standardService.deleteStandard(id);
        return ResponseEntity.noContent().build();
    }
}
