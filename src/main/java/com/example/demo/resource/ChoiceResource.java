package com.example.demo.resource;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Choice;
import com.example.demo.service.ChoiceService;

@RestController
public class ChoiceResource {
	
	public ChoiceResource(ChoiceService choiceService) {
		this.choiceService = choiceService;
	}

	private ChoiceService choiceService;
	
	@CrossOrigin
	@RequestMapping("/choices")
	public List<Choice> get() {
		return choiceService.getAll();
	}

}
