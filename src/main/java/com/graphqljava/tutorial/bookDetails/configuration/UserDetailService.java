package com.graphqljava.tutorial.bookDetails.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.graphqljava.tutorial.bookDetails.entity.MyUser;
import com.graphqljava.tutorial.bookDetails.exception.CustomException;
import com.graphqljava.tutorial.bookDetails.repository.UserRepository;
@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUser user = userRepository.findByEmail(username);
		if(user == null) {
			throw new CustomException("invalid credentials");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(), getAuthority(user));
	}

	private List<SimpleGrantedAuthority> getAuthority(MyUser user){
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		});
		
		return authorities;
	}
}
