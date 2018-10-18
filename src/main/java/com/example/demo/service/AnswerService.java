package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Choice;
import com.example.demo.repository.AnswerRepository;

@Service
public class AnswerService {

	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}

	private AnswerRepository answerRepository;
	
	public List<Answer> getAll() {
		return answerRepository.findAll();
	}
	
	public Optional<Answer> findById(Integer id) {
		return answerRepository.findById(id);
	}
	
	public void create(Answer answer) {
		answerRepository.save(answer);
	}
	
	public Answer createOrUpdateAnswer(Answer answer) {
		return answerRepository.saveAndFlush(answer);
	}

}
