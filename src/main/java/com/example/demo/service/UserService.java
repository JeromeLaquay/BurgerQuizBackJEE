package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	private UserRepository userRepository;
	
	public User createOrUpdate(User user) {
		return userRepository.saveAndFlush(user);
	}
}
