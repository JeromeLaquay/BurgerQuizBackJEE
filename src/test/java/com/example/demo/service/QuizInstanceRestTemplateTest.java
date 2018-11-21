package com.example.demo.service;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.example.demo.AbstractPackagerViewTest;
import com.example.demo.entity.QuizInstance;


public class QuizInstanceRestTemplateTest extends AbstractPackagerViewTest{

	@Test
	public void validCreation() {
		try {
			ResponseEntity<QuizInstance> quizInstance = restTemplate.postForEntity(baseUrl + "/quiz_instances/1",
					new QuizInstance(),
					QuizInstance.class);
			Assert.assertEquals(HttpStatus.OK, quizInstance.getStatusCode());
		}catch(HttpClientErrorException e) {
			Assert.fail("ok request expected");
		}
	}
	
	@Test
	public void notValidCreation() {
		try {
			restTemplate.postForEntity(baseUrl + "/quiz_instances/1000",
					new QuizInstance(),
					QuizInstance.class);
			Assert.fail("bad request expected");
		}catch(HttpClientErrorException e) {
				Assertions.assertThat(e.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		}
	}
}
