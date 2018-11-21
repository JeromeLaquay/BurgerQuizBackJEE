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

import com.example.demo.entity.Quiz;
import com.example.demo.service.QuizService;

@RestController
public class QuizResource {
	
	public QuizResource(QuizService quizService) {
		this.quizService = quizService;
	}
	private QuizService quizService;
	
	@CrossOrigin
	@RequestMapping("/quiz")
	public List<Quiz> get() {
		return quizService.getAll();
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST,value ="/quiz", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Quiz> createOrUpdateQuestion(@RequestBody Quiz quiz)  {
    	try{
    		Quiz quizz = quizService.createOrUpdate(quiz);
    		return new ResponseEntity<>(quizz, HttpStatus.OK);
    	}catch(Exception e){
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
	}

}
