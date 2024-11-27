package com.Learning.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Question question;

    private boolean passed;

    // Getters and setters
}

