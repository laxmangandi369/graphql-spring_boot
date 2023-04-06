package com.graphqljava.tutorial.bookDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import com.graphqljava.tutorial.bookDetails.entity.Role;
import com.graphqljava.tutorial.bookDetails.service.RoleService;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@MutationMapping("addRoles")
	public Role createRole(String role, String description) {
		return roleService.createRole(role, description);
	}
}
