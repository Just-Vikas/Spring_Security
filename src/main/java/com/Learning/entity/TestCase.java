package com.Learning.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String input;
    private String expectedOutput;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    // Getters and setters
}

