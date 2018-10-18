package com.example.demo.service;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.AbstractPackagerViewTest;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionServiceTest extends AbstractPackagerViewTest{
	
	public QuestionServiceTest(QuestionService questionService) {
		this.questionService = questionService;
	}

	private QuestionService questionService;
	
	
}
