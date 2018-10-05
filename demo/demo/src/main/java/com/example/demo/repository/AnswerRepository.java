package com.example.demo.repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

@Repository
public class AnswerRepository {
	
	private static final HashMap<Integer, String> DATABASE_ = new HashMap<>();
	
	public AnswerRepository() {
		DATABASE_.put(1, "premier");
		DATABASE_.put(2, "deuxieme");
		DATABASE_.put(3, "troisieme");
	}
	
	public List<String> getAll() {
		return DATABASE_.values().stream().collect(Collectors.toList());
	}
	
	public void create(String answer) {
		DATABASE_.put(DATABASE_.keySet().size()+1, answer);
	}

	
}
