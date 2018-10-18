package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Choice;
import com.example.demo.service.AnswerService;
import com.example.demo.service.ChoiceService;
import com.example.demo.service.QuestionService;

@RestController
public class ChoiceResource {
	
	public ChoiceResource(AnswerService answerService, ChoiceService choiceService) {
		this.answerService = answerService;
		this.choiceService = choiceService;
	}

	private AnswerService answerService;
	private ChoiceService choiceService;

	@RequestMapping(method = RequestMethod.POST,value ="/choices/{id}/answers", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Answer> createOrUpdateChoice(@PathVariable("id") int id, @RequestBody Answer answer)  {
    	try{
    		answer.setChoice(choiceService.findById(id).get());
    		Answer ans = answerService.createOrUpdateAnswer(answer);
    		return new ResponseEntity<Answer>(ans, HttpStatus.OK);
    	}catch(Exception e){
    		return new ResponseEntity<Answer>(HttpStatus.BAD_REQUEST);
    	}
	}
}
