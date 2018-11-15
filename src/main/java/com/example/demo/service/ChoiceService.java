package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Choice;
import com.example.demo.repository.ChoiceRepository;

@Service
public class ChoiceService {

	public ChoiceService(ChoiceRepository choiceRepository, AnswerService answerService) {
		this.choiceRepository = choiceRepository;
		this.answerService = answerService;
	}

	private ChoiceRepository choiceRepository;
	private AnswerService answerService;
	
	public List<Choice> getAll(){
		return choiceRepository.findAll();
	}
	
	public Optional<Choice> findById(Integer id) {
		return choiceRepository.findById(id);
	}
	
	public Choice createOrUpdate(Choice choice) {
		return choiceRepository.saveAndFlush(choice);
	}
	
	public void deleteAllAnswers(Choice choice) {
		List<Answer> answers = choice.getAnswers();
		for(Answer answer : answers) {
			answerService.delete(answer);
		}
	}
}
