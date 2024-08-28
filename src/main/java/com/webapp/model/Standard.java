package com.webapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Standard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // One Standard can have many Students
//    @OneToMany(mappedBy = "standard",fetch = FetchType.LAZY)
//    private Set<Student> students;

    // One Standard can have many Subjects
//    @OneToMany(mappedBy = "standard", fetch = FetchType.LAZY)
//    private Set<Subject> subjects;
//
}
