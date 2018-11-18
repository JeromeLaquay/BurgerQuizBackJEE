package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.QuizInstance;
import com.example.demo.repository.QuizInstanceRepository;

@Service
public class QuizInstanceService {

	public QuizInstanceService(QuizInstanceRepository quizInstanceRepository) {
		this.quizInstanceRepository = quizInstanceRepository;
	}

	private QuizInstanceRepository quizInstanceRepository;
	
	public List<QuizInstance> getAll(){
		return quizInstanceRepository.findAll();
	}
	
	public Optional<QuizInstance> findById(Integer id) {
		return quizInstanceRepository.findById(id);
	}
	
	public QuizInstance createOrUpdate(QuizInstance quiz) {
		return quizInstanceRepository.saveAndFlush(quiz);
	}
	

	
	
}
