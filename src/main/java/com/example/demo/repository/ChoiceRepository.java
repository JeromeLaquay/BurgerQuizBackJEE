package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Choice;

public interface ChoiceRepository extends JpaRepository<Choice, Integer>{

	@Query("SELECT c FROM Choice c, Question q WHERE c.question.id=q.id and q.id= :id")
	public List<Choice> findByQuestion(@Param("id") int idQuestion);

}
