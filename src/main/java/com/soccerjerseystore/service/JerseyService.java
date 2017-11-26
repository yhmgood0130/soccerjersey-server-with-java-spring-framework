package com.soccerjerseystore.service;

import java.util.List;

import com.soccerjerseystore.domain.Jersey;

public interface JerseyService {
	List<Jersey> findAll();
	
	Jersey findOne(Long id);
	
	Jersey save(Jersey jersey);
	
	List<Jersey> blurrySearch(String title);
	
	void removeOne(Long id);
}
