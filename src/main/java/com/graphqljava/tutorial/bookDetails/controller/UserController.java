package com.graphqljava.tutorial.bookDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.graphqljava.tutorial.bookDetails.entity.MyUser;
import com.graphqljava.tutorial.bookDetails.model.SignupModel;
import com.graphqljava.tutorial.bookDetails.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@MutationMapping("saveUser")
	public MyUser registerUser(SignupModel model) {
		return userService.registerUser(model);
	}
	@MutationMapping("loginUser")
	public Object loginUser(String username, String password) {
		return userService.loginUser(username, password);
	}

}
