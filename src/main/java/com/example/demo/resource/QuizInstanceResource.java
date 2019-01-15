package com.example.demo.resource;

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

import com.example.demo.entity.Quiz;
import com.example.demo.entity.QuizInstance;
import com.example.demo.service.QuizInstanceService;

@RestController
public class QuizInstanceResource {
	
	public QuizInstanceResource( QuizInstanceService quizInstanceService) {
		this.quizInstanceService = quizInstanceService;
	}
	
	private QuizInstanceService quizInstanceService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value="/quiz_instances/{id}")
	public ResponseEntity<QuizInstance> findById(@PathVariable("id") int id) {
		Optional<QuizInstance> quiz = quizInstanceService.findById(id);
		return quiz.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST,value ="/quiz_instances/{id}", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<QuizInstance> createOrUpdateQuestion(@RequestBody QuizInstance quizIns,@PathVariable("id") String idQuiz)  {
    	try{
    		QuizInstance quizInstance=new QuizInstance();
        	Quiz quiz=new Quiz(Integer.parseInt(idQuiz));
        	quizInstance.setNextQuestion(false);
        	quizInstance.setQuiz(quiz);
    		QuizInstance quizzInstance = quizInstanceService.createOrUpdate(quizInstance);
    		return new ResponseEntity<>(quizzInstance, HttpStatus.OK);
    	}catch(Exception e){
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
	}
}
