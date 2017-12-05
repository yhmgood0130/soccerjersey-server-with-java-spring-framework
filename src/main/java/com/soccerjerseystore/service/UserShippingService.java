package com.soccerjerseystore.service;

import com.soccerjerseystore.domain.UserShipping;

public interface UserShippingService {
	UserShipping findById(Long id);
	
	void removeById(Long id);
}
