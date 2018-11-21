package com.example.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.example.demo.AbstractPackagerViewTest;
import com.example.demo.entity.Answer;
import com.example.demo.entity.Question;


public class QuestionRestTemplateTest extends AbstractPackagerViewTest{
	
	@Test
	public void quizNotFound() {
		try {
			restTemplate.exchange(
					baseUrl + "/questions/" + 100,
					HttpMethod.GET,
					null,
					Answer.class);
			Assert.fail("should throw 404 error");
		}catch(HttpClientErrorException e) {
				Assertions.assertThat(e).isNotNull();
				Assertions.assertThat(e.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		}
	}
	
	@Test
	public void notValidCreation() {
		try {
			restTemplate.postForEntity(baseUrl + "/questions",
					new Question(),
					Question.class);
			Assert.fail("bad request expected");
		}catch(HttpClientErrorException e) {
				Assertions.assertThat(e.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		}
	}
	
	@Test
	public void validCreation() {
		try {
			ResponseEntity<Question> quizInstance = restTemplate.postForEntity(baseUrl + "/questions",
					new Question("question"),
					Question.class);
			Assert.assertEquals(HttpStatus.OK, quizInstance.getStatusCode());
		}catch(HttpClientErrorException e) {
			Assert.fail("ok request expected");
		}
	}
	
}
