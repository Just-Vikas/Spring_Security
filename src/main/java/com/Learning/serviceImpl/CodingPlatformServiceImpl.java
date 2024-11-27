package com.Learning.serviceImpl;

import com.Learning.entity.Submission;
import com.Learning.entity.TestCase;
import com.Learning.repository.QuestionRepository;
import com.Learning.repository.SubmissionRepository;
import com.Learning.entity.Question;
import com.Learning.service.CodingPlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CodingPlatformServiceImpl implements CodingPlatformService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private SubmissionRepository submissionRepository;

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Question not found"));
    }

    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Submission submitCode(Long questionId, String code, String language) {
        Question question = getQuestionById(questionId);
        List<TestCase> testCases = question.getTestCases();
        boolean passedAll = true;

        for (TestCase testCase : testCases) {
            String output = executeCode(code, language, testCase.getInput());
            if (!output.trim().equals(testCase.getExpectedOutput().trim())) {
                passedAll = false;
                break;
            }
        }

        Submission submission = new Submission();
        submission.setUser(null); // Set the logged-in user (implement authentication)
        submission.setQuestion(question);
        submission.setPassed(passedAll);
        return submissionRepository.save(submission);
    }

    private String executeCode(String code, String language, String input) {
        // Placeholder for code execution logic
        // Use an external API or secure environment to run the code
        return "dummyOutput"; // Replace with actual output
    }
}

