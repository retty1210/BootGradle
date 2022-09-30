package com.gradle.test.boot_gradle.question;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradle.test.boot_gradle.vo.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);

    Question findBySubjectAndContent(String subject, String content);

    List<Question> findBySubjectLike(String subject);

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
}