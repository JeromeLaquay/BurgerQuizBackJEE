package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	
	@NotEmpty
	private String text;
	
	@OneToMany(mappedBy="question")
	private List<Choice> choices;
	
	private String type_q;
	
	@JsonIgnore
	@ManyToOne
	private Quiz quiz;
	
	public Question() {
	}
	
	public Question(String text, String type_q) {
		super();
		this.text = text;
		this.type_q = type_q;
	}

	public Question(String text, List<Choice> choices) {
		super();
		this.text = text;
		this.choices = choices;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Choice> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public String getTypeQ() {
		return type_q;
	}

	public void setTypeQ(String type_q) {
		this.type_q = type_q;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", text=" + text + ", choices=" + choices + ", type_q=" + type_q + ", quiz=" + quiz
				+ "]";
	}
	
}