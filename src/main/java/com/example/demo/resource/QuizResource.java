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

import com.example.demo.entity.Question;
import com.example.demo.entity.Quiz;
import com.example.demo.service.QuestionService;
import com.example.demo.service.QuizService;

@RestController
public class QuizResource {
	
	public QuizResource(QuestionService questionService, QuizService quizService) {
		this.questionService = questionService;
		this.quizService = quizService;
	}

	private QuestionService questionService;
	private QuizService quizService;
	
	@RequestMapping("/quiz")
	public List<Quiz> get() {
		return quizService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/quiz/{id}")
	public ResponseEntity<Quiz> findById(@PathVariable("id") int id) {
		Optional<Quiz> quiz = quizService.findById(id);
		return quiz.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
	
	@RequestMapping(method = RequestMethod.POST,value ="/quiz", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Quiz> createOrUpdateQuestion(@RequestBody Quiz quiz)  {
    	try{
    		Quiz quizz = quizService.createOrUpdate(quiz);
    		return new ResponseEntity<>(quizz, HttpStatus.OK);
    	}catch(Exception e){
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
	}
	
	@RequestMapping(method = RequestMethod.POST,value ="/quiz/{id}/questions", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Question> createOrUpdateChoice(@PathVariable("id") int id, @RequestBody Question question)  {
    	try{
    		Optional<Quiz> quiz = quizService.findById(id);
    		if(quiz.isPresent()) {
    			question.setQuiz(quiz.get());
	    		Question quest = questionService.createOrUpdate(question);
	    		return new ResponseEntity<>(quest, HttpStatus.OK);
    		}
    	}catch(Exception e){
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
    	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	

}
