package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	
	@JsonIgnore
	@ManyToOne
	private Choice choice;
	
	@JsonIgnore
	@ManyToOne
	private QuizInstance quizInstance;
	
	
	public Answer() {
	}

	public Answer(Integer id, Choice choice, QuizInstance quizInstance) {
		super();
		this.id = id;
		this.choice = choice;
		this.quizInstance = quizInstance;
	}

	public Answer(Choice choice, QuizInstance quizInstance) {
		super();
		this.choice = choice;
		this.quizInstance = quizInstance;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Choice getChoice() {
		return choice;
	}


	public void setChoice(Choice choice) {
		this.choice = choice;
	}


	public QuizInstance getQuizInstance() {
		return quizInstance;
	}


	public void setQuizInstance(QuizInstance quizInstance) {
		this.quizInstance = quizInstance;
	}

	@Override
	public String toString() {
		return "Answer [id=" + id + ", choice=" + choice.getId() + ", quizInstance=" + quizInstance.getId() + "]";
	}
	
	
	
}
