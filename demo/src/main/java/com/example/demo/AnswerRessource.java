package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Answer;
import com.example.demo.service.AnswerService;

@RestController
public class AnswerRessource {
	
	
	public AnswerRessource(AnswerService answerService) {
		this.answerService = answerService;
	}

	private AnswerService answerService;
	
	@RequestMapping("/answers")
	public List<Answer> get() {
		return answerService.getAll();
	}
	
//	@RequestMapping(value = "/answers",method=RequestMethod.POST)
//	public void create(@RequestParam("answer") String answer) {
//		answerService.create(answer);
//	}
}
