package com.example.demo;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Answer;
import com.example.demo.service.AnswerService;

@RestController("/answers")
public class AnswerResource {
	
	
	public AnswerResource(AnswerService answerService) {
		this.answerService = answerService;
	}

	private AnswerService answerService;
	
	@RequestMapping("/answers")
	public List<Answer> get() {
		return answerService.getAll();
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/answers" , produces={MediaType.APPLICATION_JSON_VALUE}, consumes={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> createOrUpdateAnswer(@Valid @RequestBody Answer answer)  {
		if(answer.getValue().isEmpty() || answer.getValue() == null ) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		answerService.createOrUpdate(answer);
		return new ResponseEntity<>("The answer is created", HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/answers/{id}")
	public ResponseEntity<Answer> findById(@PathVariable("id") int id) {
		Optional<Answer> answer = answerService.findById(id);
		return answer.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
		
	}
}
