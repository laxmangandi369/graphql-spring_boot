package com.graphqljava.tutorial.bookDetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.graphqljava.tutorial.bookDetails.configuration.JwtUtil;
import com.graphqljava.tutorial.bookDetails.dao.UserDao;
import com.graphqljava.tutorial.bookDetails.entity.MyUser;
import com.graphqljava.tutorial.bookDetails.model.SignupModel;
import com.graphqljava.tutorial.bookDetails.repository.RoleRepository;

public interface UserService {
	

	MyUser registerUser(SignupModel signupModel);
	
	Object loginUser(String username, String password);
}
