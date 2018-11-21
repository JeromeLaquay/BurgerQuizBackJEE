package com.example.demo.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Question;
import com.example.demo.service.QuestionService;

@RestController
public class QuestionResource {
	
	public QuestionResource(QuestionService questionService) {
		this.questionService = questionService;
	}

	private QuestionService questionService;
	
	@CrossOrigin
	@RequestMapping("/questions")
	public List<Question> get() {
		return questionService.getAll();
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST,value ="/questions", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Question> createOrUpdateQuestion(@RequestBody Question question)  {
    	try{
    		Question quest = questionService.createOrUpdate(question);
    		return new ResponseEntity<>(quest, HttpStatus.OK);
    	}catch(Exception e){
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
	}

}
