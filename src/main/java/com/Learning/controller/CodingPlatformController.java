package com.Learning.controller;

import com.Learning.entity.Question;
import com.Learning.entity.Submission;
import com.Learning.service.CodingPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CodingPlatformController {

    @Autowired
    private CodingPlatformService codingPlatformService;

    // Fetch all questions (Accessible to both ADMIN and USER roles)
    @GetMapping("/questions")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public List<Question> getAllQuestions() {
        return codingPlatformService.getAllQuestions();
    }

    // Get a specific question by ID (Accessible to both ADMIN and USER roles)
    @GetMapping("/questions/{id}")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public Question getQuestionById(@PathVariable Long id) {
        return codingPlatformService.getQuestionById(id);
    }

    // Add a new question (Admin-only endpoint)
    @PostMapping("/questions")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addQuestion(@RequestBody Question question) {
        codingPlatformService.addQuestion(question);
    }

    // Submit code for a specific question (Accessible to both ADMIN and USER roles)
    @PostMapping("/questions/{id}/submit")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public Submission submitCode(
            @PathVariable Long id,
            @RequestParam String code,
            @RequestParam String language
    ) {
        return codingPlatformService.submitCode(id, code, language);
    }
}
