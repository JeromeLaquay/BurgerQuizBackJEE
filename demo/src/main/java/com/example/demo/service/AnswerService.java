package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Answer;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.AnswerRepositoryInt;

@Service
public class AnswerService {

	public AnswerService(AnswerRepositoryInt answerRepository) {
		this.answerRepository = answerRepository;
	}

	private AnswerRepositoryInt answerRepository;
	
	public List<Answer> getAll() {
		return answerRepository.findAll();
	}
	
	public void create(Answer answer) {
		answerRepository.save(answer);
	}
	

}
