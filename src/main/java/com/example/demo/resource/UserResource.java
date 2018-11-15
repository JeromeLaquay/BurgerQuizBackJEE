package com.example.demo.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserResource {

	public UserResource(UserService userService) {
		this.userService = userService;
	}

	private UserService userService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/subscription")
	public ResponseEntity<User> create(@RequestBody User user) {
		try{
    		User user2 = userService.createOrUpdate(user);
    		return new ResponseEntity<>(user2, HttpStatus.OK);
    	}catch(Exception e){
    		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    	}
	}
	
}
