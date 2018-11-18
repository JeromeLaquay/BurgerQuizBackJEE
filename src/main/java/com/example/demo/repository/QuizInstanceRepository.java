package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.QuizInstance;

public interface QuizInstanceRepository extends JpaRepository<QuizInstance, Integer>{

	
}
