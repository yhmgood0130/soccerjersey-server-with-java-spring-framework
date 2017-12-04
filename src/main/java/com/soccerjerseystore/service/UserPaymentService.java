package com.soccerjerseystore.service;

import com.soccerjerseystore.domain.UserPayment;

public interface UserPaymentService {
	UserPayment findById(Long id);
	
	void removeById(Long id);
}
