package com.soccerjerseystore.resource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soccerjerseystore.config.SecurityUtility;
import com.soccerjerseystore.domain.User;
import com.soccerjerseystore.domain.security.Role;
import com.soccerjerseystore.domain.security.UserRole;
import com.soccerjerseystore.service.UserService;
import com.soccerjerseystore.utility.MailConstructor;

@RestController
@RequestMapping("/user")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MailConstructor mailConstructor;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@RequestMapping(value="/newUser", method=RequestMethod.POST)
	public ResponseEntity newUserPost(
			HttpServletRequest request,
			@RequestBody HashMap<String, String> mapper
			) throws Exception {
		String username = mapper.get("username");
		String userEmail = mapper.get("email");
		
		if(userService.findByUsername(username) != null) {
			return new ResponseEntity("usernameExists", HttpStatus.BAD_REQUEST);
		}
		
		if(userService.findByEmail(userEmail) != null) {
			return new ResponseEntity("emailExists", HttpStatus.BAD_REQUEST);
		}
		
		User user = new User();
		user.setUsername(username);
		user.setEmail(userEmail);
		
		String password = SecurityUtility.randomPassword();
		
		String encryptedPassword = SecurityUtility.passwordEncoder().encode(password);
		user.setPassword(encryptedPassword);
		
		Role role = new Role();
		role.setRoleId(1);
		role.setName("ROLE_USER");
		Set<UserRole> userRoles = new HashSet<>();
		userRoles.add(new UserRole(user,role));
		userService.createUser(user,userRoles);
		
		SimpleMailMessage email = mailConstructor.constructNewUserEmail(user, password);
		mailSender.send(email);
		
		return new ResponseEntity("User Added Successfully!", HttpStatus.OK);
	}
}
