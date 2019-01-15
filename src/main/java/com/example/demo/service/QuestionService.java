package com.example.demo.service;

import java.util.List;

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
	
	public Question createOrUpdate(Question question) {
		return questionRepository.saveAndFlush(question);
	}
}
