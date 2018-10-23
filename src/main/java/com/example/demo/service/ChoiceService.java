package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Choice;
import com.example.demo.repository.ChoiceRepository;

@Service
public class ChoiceService {

	public ChoiceService(ChoiceRepository choiceRepository) {
		this.choiceRepository = choiceRepository;
	}

	private ChoiceRepository choiceRepository;
	
	public List<Choice> getAll(){
		return choiceRepository.findAll();
	}
	
	public Optional<Choice> findById(Integer id) {
		return choiceRepository.findById(id);
	}
	
	public Choice createOrUpdate(Choice choice) {
		return choiceRepository.saveAndFlush(choice);
	}
}
