package com.example.demo.service;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.example.demo.AbstractPackagerViewTest;
import com.example.demo.entity.Answer;


public class AnswerRestTemplateTest extends AbstractPackagerViewTest{

	@Test
	public void foundAnswer() {
		int expectedId=1;
		ResponseEntity<Answer> response = restTemplate.exchange(baseUrl + "/answers/" + expectedId, 
				HttpMethod.GET,
				null,
				Answer.class);
		Assertions.assertThat(response).isNotNull();
		Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		Assertions.assertThat(response.getBody().getId()).isEqualTo(expectedId);
	}
	
	@Test
	public void answerNotFound() {
		try {
			restTemplate.exchange(
					baseUrl + "/answers/" + (MAX_ELEMENT + 200),
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
			restTemplate.postForEntity(baseUrl + "/answers",
					new Answer(),
					Answer.class);
			Assert.fail("bad request expected");
		}catch(HttpClientErrorException e) {
				Assertions.assertThat(e.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		}
	}
}
