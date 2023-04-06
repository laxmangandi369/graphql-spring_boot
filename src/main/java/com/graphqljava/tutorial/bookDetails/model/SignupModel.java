package com.graphqljava.tutorial.bookDetails.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.graphqljava.tutorial.bookDetails.entity.Role;

import lombok.Data;

@Data
public class SignupModel {

	private String firstName;
	private String lastName;
	private String email;
	@JsonIgnore
	private String password;
	private List<Role> roles;
}
