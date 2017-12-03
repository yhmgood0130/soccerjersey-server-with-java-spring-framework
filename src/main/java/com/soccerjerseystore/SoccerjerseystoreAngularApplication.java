package com.soccerjerseystore;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.soccerjerseystore.config.SecurityUtility;
import com.soccerjerseystore.domain.User;
import com.soccerjerseystore.domain.security.Role;
import com.soccerjerseystore.domain.security.UserRole;
import com.soccerjerseystore.service.UserService;

@SpringBootApplication
public class SoccerjerseystoreAngularApplication implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SoccerjerseystoreAngularApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
//		User user1 = new User();
//		user1.setFirstName("John");
//		user1.setLastName("Doe");
//		user1.setUsername("johndoe47");
//		user1.setPassword(SecurityUtility.passwordEncoder().encode("password47"));
//		user1.setEmail("jdoe47@gmail.com");
//		Set<UserRole> userRoles = new HashSet<>();
//		Role role1 = new Role();
//		role1.setRoleId(1);
//		role1.setName("ROLE_USER");
//		userRoles.add(new UserRole(user1, role1));
//		
//		userService.createUser(user1, userRoles);
//		
//		userRoles.clear();
//		
//		User user2 = new User();
//		user2.setFirstName("Web");
//		user2.setLastName("Admin");
//		user2.setUsername("admin");
//		user2.setPassword(SecurityUtility.passwordEncoder().encode("dazbogManager47"));
//		user2.setEmail("admin@gmail.com");
//		Role role2 = new Role();
//		role2.setRoleId(0);
//		role2.setName("ROLE_ADMIN");
//		userRoles.add(new UserRole(user2, role2));
//
//		userService.createUser(user2, userRoles);
		
	}
}
