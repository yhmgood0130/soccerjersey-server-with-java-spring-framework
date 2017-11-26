package com.soccerjerseystore.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soccerjerseystore.domain.Jersey;
import com.soccerjerseystore.service.JerseyService;

@RestController
@RequestMapping("/jersey")
public class JerseyResource {
	@Autowired
	private JerseyService jerseyService; 
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Jersey addJerseyPost(@RequestBody Jersey jersey) {
		return jerseyService.save(jersey);
	}
}
