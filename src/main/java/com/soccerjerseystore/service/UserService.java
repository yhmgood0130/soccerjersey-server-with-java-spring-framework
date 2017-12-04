package com.soccerjerseystore.service;

import java.util.Set;

import com.soccerjerseystore.domain.User;
import com.soccerjerseystore.domain.UserBilling;
import com.soccerjerseystore.domain.UserPayment;
import com.soccerjerseystore.domain.security.UserRole;


public interface UserService {
	User createUser(User user, Set<UserRole> userRoles);
	
	User findByUsername(String username);
	
	User findByEmail(String email);
	
	User save(User user);
	User findById(Long id);
	
	void updateUserPaymentInfo(UserBilling userBilling, UserPayment userPayment, User user);
	
	void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);
	
	void setUserDefaultPayment(Long userPaymentId, User user);
	
}
