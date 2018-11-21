package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="quiz_instance")
public class QuizInstance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	
	private boolean nextQuestion;
	
	@ManyToOne
	private Quiz quiz;
	
	@OneToMany(mappedBy="quizInstance")
	private List<Answer> answers; 
	
	public QuizInstance() {
	}
	
	public QuizInstance(boolean nextQuestion) {
		super();
		this.nextQuestion = nextQuestion;
	}

	public QuizInstance(Integer id, boolean nextQuestion, Quiz quiz) {
		super();
		this.id = id;
		this.nextQuestion = nextQuestion;
		this.quiz = quiz;
	}

	public QuizInstance(Integer id, boolean nextQuestion, Quiz quiz, List<Answer> answers) {
		super();
		this.id = id;
		this.nextQuestion = nextQuestion;
		this.quiz = quiz;
		this.answers = answers;
	}

	public QuizInstance(Integer id) {
		super();
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isNextQuestion() {
		return nextQuestion;
	}

	public void setNextQuestion(boolean nextQuestion) {
		this.nextQuestion = nextQuestion;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	@Override
	public String toString() {
		return "QuizInstance [id=" + id + ", nextQuestion=" + nextQuestion + ", quiz=" + quiz + "]";
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	
	
}