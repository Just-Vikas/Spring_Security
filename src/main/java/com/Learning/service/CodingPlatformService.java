package com.Learning.service;



import com.Learning.entity.Question;
import com.Learning.entity.Submission;

import java.util.List;

public interface CodingPlatformService {
    List<Question> getAllQuestions();
    Question getQuestionById(Long id);
    void addQuestion(Question question);
    Submission submitCode(Long questionId, String code, String language);
}

