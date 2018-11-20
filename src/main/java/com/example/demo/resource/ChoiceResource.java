package com.example.demo.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Choice;
import com.example.demo.service.AnswerService;
import com.example.demo.service.ChoiceService;

@RestController
public class ChoiceResource {
	
	public ChoiceResource(AnswerService answerService, ChoiceService choiceService) {
		this.answerService = answerService;
		this.choiceService = choiceService;
	}

	private AnswerService answerService;
	private ChoiceService choiceService;
	
	@CrossOrigin
	@RequestMapping("/choices")
	public List<Choice> get() {
		return choiceService.getAll();
	}
	
	@CrossOrigin
	@RequestMapping("/questions/{id}/choices")
	public List<Choice> getByQuestion(@PathVariable("id") int idQuestion) {
		return choiceService.findByQuestion(idQuestion);
	}

}
