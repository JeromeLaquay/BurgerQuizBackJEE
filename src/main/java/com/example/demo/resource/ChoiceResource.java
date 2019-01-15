package com.example.demo.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Choice;
import com.example.demo.service.ChoiceService;

@RestController
public class ChoiceResource {
	
	public ChoiceResource(ChoiceService choiceService) {
		this.choiceService = choiceService;
	}

	private ChoiceService choiceService;
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST,value ="/choices", produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Choice> createOrUpdateQuestion(@RequestBody Choice choice)  {
    	try{
    		Choice choix = choiceService.createOrUpdate(choice);
    		return new ResponseEntity<>(choix, HttpStatus.OK);
    	}catch(Exception e){
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
	}

}
