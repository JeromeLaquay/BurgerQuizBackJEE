package com.example.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.example.demo.AbstractPackagerViewTest;
import com.example.demo.entity.Answer;
import com.example.demo.entity.Quiz;


public class QuizRestTemplateTest extends AbstractPackagerViewTest{
	
	@Test
	public void quizNotFound() {
		try {
			restTemplate.exchange(
					baseUrl + "/quiz/" + 100,
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
			restTemplate.postForEntity(baseUrl + "/quiz",
					new Quiz(),
					Quiz.class);
			Assert.fail("bad request expected");
		}catch(HttpClientErrorException e) {
				Assertions.assertThat(e.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		}
	}
	
}
