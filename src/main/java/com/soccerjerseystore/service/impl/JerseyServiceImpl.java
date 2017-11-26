package com.soccerjerseystore.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soccerjerseystore.domain.Jersey;
import com.soccerjerseystore.repository.JerseyRepository;
import com.soccerjerseystore.service.JerseyService;

@Service
public class JerseyServiceImpl implements JerseyService{
	
	@Autowired
	private JerseyRepository jerseyRepository;
	
	public List<Jersey> findAll() {
		List<Jersey> jerseyList = (List<Jersey>) jerseyRepository.findAll();
		
		List<Jersey> activeJerseyList = new ArrayList<>();
		
		for (Jersey jersey : jerseyList) {
			if(jersey.isActive()) {
				activeJerseyList.add(jersey);
			}
		}
		return activeJerseyList;
	}
	
	public Jersey findOne(Long id) {
		return jerseyRepository.findOne(id);
	}
	
	public Jersey save (Jersey jersey) {
		return jerseyRepository.save(jersey);
	}
	
	public List<Jersey> blurrySearch(String keyword) {
		List<Jersey> jerseyList =  jerseyRepository.findByTitleContaining(keyword);
		
		List<Jersey> activeJerseyList = new ArrayList<>();
	
		for(Jersey jersey : jerseyList) {
			if(jersey.isActive()) {
				activeJerseyList.add(jersey);
			}
		}
		
		return activeJerseyList;
	}
	
	public void removeOne(Long id) {
		jerseyRepository.delete(id);
	}

}
