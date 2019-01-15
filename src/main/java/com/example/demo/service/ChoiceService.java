package com.example.demo.service;

import java.util.List;

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
	
	public Choice createOrUpdate(Choice choice) {
		return choiceRepository.saveAndFlush(choice);
	}

}
