package com.graphqljava.tutorial.bookDetails.service;

import com.graphqljava.tutorial.bookDetails.entity.Role;

public interface RoleService {

	Role createRole(String role, String description);
}
