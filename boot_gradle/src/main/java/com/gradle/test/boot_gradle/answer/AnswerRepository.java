package com.gradle.test.boot_gradle.answer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gradle.test.boot_gradle.vo.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
