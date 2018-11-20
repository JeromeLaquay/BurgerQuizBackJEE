package com.example.demo.resource;

import java.util.List;

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
import com.example.demo.entity.QuizInstance;
import com.example.demo.service.AnswerService;

@RestController
public class AnswerResource {
	
	
	public AnswerResource(AnswerService answerService) {
		this.answerService = answerService;
	}

	private AnswerService answerService;
	
	//getAll
	@CrossOrigin
	@RequestMapping("/answers")
	public List<Answer> get() {
		return answerService.getAll();
	}
	
	@CrossOrigin
	@RequestMapping("/questions/{id}/answers")
	public List<Answer> getByQuestion(@PathVariable("id") int idQuestion) {
		return answerService.getByQuestion(idQuestion);
	}
	
	//createOrUpdate
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST,value = "/answers/{idQuizInstance}/{idChoice}" , produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Answer> createOrUpdateAnswer(@RequestBody Answer answ, @PathVariable("idQuizInstance") String idQuizInstance, @PathVariable("idChoice") String idChoice)  {
		System.out.println("idquiins = "+ idQuizInstance + " idchoice ="+ idChoice);
		try {
			Answer answer=new Answer();
			QuizInstance quizInstance=new QuizInstance(Integer.parseInt(idQuizInstance));
			Choice choice=new Choice(Integer.parseInt(idChoice));
			answer.setQuizInstance(quizInstance);
			answer.setChoice(choice);
			Answer answer2=answerService.createOrUpdate(answer);
			return new ResponseEntity<>(answer2, HttpStatus.OK);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
