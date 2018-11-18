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

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST,value ="/choices", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Answer> createOrUpdateChoice(@PathVariable("id") int id, @RequestBody Answer answer)  {
    	try{
    		Optional<Choice> choix = choiceService.findById(id);
    		if(choix.isPresent()) {
    			answer.setChoice(choix.get());
        		Answer ans = answerService.createOrUpdate(answer);
        		return new ResponseEntity<>(ans, HttpStatus.OK);
    		}
    	}catch(Exception e){
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
