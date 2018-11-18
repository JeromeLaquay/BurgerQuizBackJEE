package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer>{

	@Query("SELECT a FROM Answer a,Choice c, Question q WHERE a.choice.id=c.id and c.question.id=q.id and q.id= :id")
	public List<Answer> findByQuestion(@Param("id") int idQuestion);
}
