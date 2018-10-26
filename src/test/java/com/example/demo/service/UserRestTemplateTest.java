package com.example.demo.service;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import com.example.demo.AbstractPackagerViewTest;
import com.example.demo.entity.User;


public class UserRestTemplateTest extends AbstractPackagerViewTest{

	@Test
	@Transactional
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
}
