package com.gradle.test.boot_gradle.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gradle.test.boot_gradle.vo.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findBySubject(String subject);

    Question findBySubjectAndContent(String subject, String content);

    List<Question> findBySubjectLike(String subject);

    Page<Question> findAll(Pageable pageable);

    Page<Question> findAll(Specification<Question> spec, Pageable pageable);

    @Query("select distinct q"
            + " from Question q"
            + " left outer join SiteUser u1 on q.author=u1"
            + " left outer join Answer a on a.question=1"
            + " left outer join SiteUser u2 on a.author=u2"
            + " where q.subject like %:kw%"
            + " or q.content like %:kw%"
            + " or u1.username like %:kw%"
            + " or a.content like %:kw%"
            + " or u2.username like %:kw%") // Query는 반드시 table 기준이 아닌 entity 기준으로 작성하여야 한다.
    Page<Question> findAllByKeyword(@Param("kw") String kw, Pageable pageable);

    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
}
