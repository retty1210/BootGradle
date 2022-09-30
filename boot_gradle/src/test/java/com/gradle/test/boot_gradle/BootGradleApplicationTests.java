package com.gradle.test.boot_gradle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gradle.test.boot_gradle.question.QuestionRepository;
import com.gradle.test.boot_gradle.vo.Question;

@SpringBootTest
class BootGradleApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testJpa() {
		Question q1 = new Question();
		q1.setSubject("Q1S");
		q1.setContent("Q1C");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);

		Question q2 = new Question();
		q2.setSubject("Q2S");
		q2.setContent("Q2C");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);
	}

	@Test
	void testJpaRead() {
		// findAll()
		List<Question> all = this.questionRepository.findAll();
		assertEquals(2, all.size());

		Question q = all.get(0);
		assertEquals("Q1S", q.getSubject());

		// findById()
		Optional<Question> oq = this.questionRepository.findById(1);
		if (oq.isPresent()) {
			Question q1 = oq.get();
			assertEquals("Q1S", q1.getSubject());
		}

		// findBySubject()
		Question q2 = this.questionRepository.findBySubject("Q1S");
		assertEquals(1, q2.getId());
	}

}
