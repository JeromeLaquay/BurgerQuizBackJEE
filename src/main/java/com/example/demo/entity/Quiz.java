package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	
	@NotEmpty
	private String name;
	
	@OneToMany(mappedBy="quiz")
	private List<Question> questions;
	
	@JsonIgnore
	@OneToMany(mappedBy="quiz")
	private List<QuizInstance> instances;
	
	public Quiz() {
	}
	
	public Quiz(Integer id) {
		super();
		this.id = id;
	}

	public Quiz(String name, List<Question> questions, List<QuizInstance> instances) {
		super();
		this.name = name;
		this.questions = questions;
		this.instances=instances;
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

	public List<QuizInstance> getInstances() {
		return instances;
	}

	public void setInstances(List<QuizInstance> instances) {
		this.instances = instances;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", name=" + name + ", questions=" + questions + ", instances=" + instances + "]";
	}

	
	
}