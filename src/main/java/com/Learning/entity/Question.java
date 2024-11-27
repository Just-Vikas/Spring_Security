package com.Learning.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String sampleInput;
    private String sampleOutput;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<TestCase> testCases;

    // Getters and setters
}

