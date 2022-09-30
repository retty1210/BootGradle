package com.gradle.test.boot_gradle.question;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gradle.test.boot_gradle.DataNotFoundException;
import com.gradle.test.boot_gradle.vo.Question;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }
}
