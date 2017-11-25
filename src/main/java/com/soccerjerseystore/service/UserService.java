package com.soccerjerseystore.service;

import java.util.Set;

import com.soccerjerseystore.domain.User;
import com.soccerjerseystore.domain.security.UserRole;

public interface UserService {
	User createUser(User user, Set<UserRole> userRoles);
}
