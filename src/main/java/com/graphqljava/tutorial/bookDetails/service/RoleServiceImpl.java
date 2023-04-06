package com.graphqljava.tutorial.bookDetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphqljava.tutorial.bookDetails.entity.Role;
import com.graphqljava.tutorial.bookDetails.exception.CustomException;
import com.graphqljava.tutorial.bookDetails.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public Role createRole(String role, String description) {
		if(roleRepository.findByRole(role) == null) {
			Role role2 = new Role();
			role2.setRole(role);
			role2.setDescription(description);
			return roleRepository.save(role2);
		} else {
			throw new CustomException(role+" already present.");
		}
	}

}
