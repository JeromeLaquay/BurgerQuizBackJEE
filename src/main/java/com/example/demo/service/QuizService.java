package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Quiz;
import com.example.demo.repository.QuizRepository;

@Service
public class QuizService {

	public QuizService(QuizRepository quizRepository) {
		this.quizRepository = quizRepository;
	}

	private QuizRepository quizRepository;
	
	public List<Quiz> getAll(){
		return quizRepository.findAll();
	}
	
	public Optional<Quiz> findById(Integer id) {
		return quizRepository.findById(id);
	}
	
	public Quiz createOrUpdate(Quiz quiz) {
		return quizRepository.saveAndFlush(quiz);
	}
	

	
	
}
