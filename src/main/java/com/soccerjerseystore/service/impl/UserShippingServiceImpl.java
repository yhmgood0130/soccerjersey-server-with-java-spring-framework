package com.soccerjerseystore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soccerjerseystore.domain.UserShipping;
import com.soccerjerseystore.repository.UserShippingRepository;
import com.soccerjerseystore.service.UserShippingService;

@Service
public class UserShippingServiceImpl implements UserShippingService{
	@Autowired
	private UserShippingRepository userShippingRepository;
	
	public UserShipping findById(Long id) {
		return userShippingRepository.findOne(id);
	}
	
	public void removeById(Long id) {
		userShippingRepository.delete(id);
	}
}
