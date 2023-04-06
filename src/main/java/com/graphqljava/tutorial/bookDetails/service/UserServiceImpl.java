package com.graphqljava.tutorial.bookDetails.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.graphqljava.tutorial.bookDetails.configuration.JwtUtil;
import com.graphqljava.tutorial.bookDetails.dao.UserDao;
import com.graphqljava.tutorial.bookDetails.entity.MyUser;
import com.graphqljava.tutorial.bookDetails.entity.Role;
import com.graphqljava.tutorial.bookDetails.exception.CustomException;
import com.graphqljava.tutorial.bookDetails.model.SignupModel;
import com.graphqljava.tutorial.bookDetails.repository.RoleRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public MyUser registerUser(SignupModel signupModel) {
		if(userDao.findByEmail(signupModel.getEmail())==null) {
			List<Role> roles = new ArrayList<>();
			
			MyUser user = new MyUser();
			
			roles.add(roleRepository.findByRole("user_read"));
			roles.add(roleRepository.findByRole("user_write"));
			
			user = mapper.map(signupModel, MyUser.class);
			
			user.setPassword(bCryptPasswordEncoder.encode(signupModel.getPassword()));
			
			user.setRoles(roles);
			
			userDao.signupUser(user);
			
			return user;
		} else {
			throw new CustomException(signupModel.getEmail()+" already registered");
		}
	}

	@Override
	public Object loginUser(String username, String password) {
		Map<String, Object> data =  new HashMap<>();
		
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
			SecurityContextHolder.getContext().setAuthentication(authentication);
			
			String jwtToken = jwtUtil.generateToken(authentication);
			
			MyUser user = (MyUser)authentication.getPrincipal();
			
			List<String> roles = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
			
			data.put("token", jwtToken);
			data.put("username", user.getEmail());
			data.put("authority", user.getAuthorities());
			data.put("roles", roles);
					
		} catch (Exception e) {
			throw new CustomException("Authentication failed");
		}
		
		return data;
	}

}
