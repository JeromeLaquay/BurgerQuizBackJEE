package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Answer;
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
	
	public List<Answer> getByQuestion(int idQuestion) {
		return answerRepository.findByQuestion(idQuestion);
	}
	
	public Optional<Answer> findById(Integer id) {
		return answerRepository.findById(id);
	}
	
	public Answer createOrUpdate(Answer answer) {
		return answerRepository.saveAndFlush(answer);
	}
	
	public void delete(Answer answer) {
		answerRepository.delete(answer);
	}

}
