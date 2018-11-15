package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;

@Service
public class QuestionService {

	public QuestionService(QuestionRepository questionRepository) {
		this.questionRepository = questionRepository;
	}

	private QuestionRepository questionRepository;
	
	public List<Question> getAll(){
		return questionRepository.findAll();
	}
	
	public Optional<Question> findById(Integer id) {
		return questionRepository.findById(id);
	}
	
	public Question createOrUpdate(Question question) {
		return questionRepository.saveAndFlush(question);
	}
	

	
	
}
