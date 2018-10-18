package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Choice;
import com.example.demo.entity.Question;
import com.example.demo.service.ChoiceService;
import com.example.demo.service.QuestionService;

@RestController
public class QuestionResource {
	
	public QuestionResource(QuestionService questionService, ChoiceService choiceService) {
		this.questionService = questionService;
		this.choiceService = choiceService;
	}

	private QuestionService questionService;
	private ChoiceService choiceService;
	
	@RequestMapping("/questions")
	public List<Question> get() {
		List<Question> questions = questionService.getAll();
		return questionService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/questions/{id}")
	public ResponseEntity<Question> findById(@PathVariable("id") int id) {
		Optional<Question> question = questionService.findById(id);
		return question.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	@RequestMapping(method = RequestMethod.POST,value ="/questions", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Question> createOrUpdateQuestion(@RequestBody Question question)  {
    	try{
    		Question quest = questionService.update(question);
    		return new ResponseEntity<Question>(quest, HttpStatus.OK);
    	}catch(Exception e){
    		return new ResponseEntity<Question>(HttpStatus.BAD_REQUEST);
    	}
	}
	
	@RequestMapping(method = RequestMethod.POST,value ="/questions/{id}/choices", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Choice> createOrUpdateChoice(@PathVariable("id") int id, @RequestBody Choice choice)  {
    	try{
    		choice.setQuestion(questionService.findById(id).get());
    		Choice choi = choiceService.createOrUpdateChoice(choice);
    		return new ResponseEntity<Choice>(choi, HttpStatus.OK);
    	}catch(Exception e){
    		return new ResponseEntity<Choice>(HttpStatus.BAD_REQUEST);
    	}
	}
	
	

}
