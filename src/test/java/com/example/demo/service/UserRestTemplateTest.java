package com.example.demo.service;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.example.demo.AbstractPackagerViewTest;
import com.example.demo.entity.Answer;
import com.example.demo.entity.User;


public class UserRestTemplateTest extends AbstractPackagerViewTest{

	@Test
	public void notValidCreation() {
		try {
			restTemplate.postForEntity(baseUrl + "/subscription",
					new User("",true),
					User.class);
			Assert.fail("bad request expected");
		}catch(HttpClientErrorException e) {
				Assertions.assertThat(e.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
		}
	}
	
	@Test
	public void validCreation() {
		try {
			ResponseEntity<User> quizInstance = restTemplate.postForEntity(baseUrl + "/subscription",
					new User("jl@mail.fr",true),
					User.class);
			Assert.assertEquals(HttpStatus.OK, quizInstance.getStatusCode());
		}catch(HttpClientErrorException e) {
			Assert.fail("ok request expected");
		}
	}
	
}
