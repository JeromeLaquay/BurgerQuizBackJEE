package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	
	private String name;
	
	@OneToMany(mappedBy="quiz")
	private List<Question> questions;
	
	public Quiz() {
	}
	
	public Quiz(String name) {
		super();
		this.name = name;
	}

	public Quiz(String name, List<Question> questions) {
		super();
		this.name = name;
		this.questions = questions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", name=" + name + ", questions=" + questions + "]";
	}
	
	
}