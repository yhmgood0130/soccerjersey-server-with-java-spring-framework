package com.soccerjerseystore.resource;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	
	@RequestMapping(value="/add/image", method=RequestMethod.POST)
	public ResponseEntity upload(
			@RequestParam("id") Long id,
			HttpServletResponse response, HttpServletRequest request
			) {
		try {
			Jersey jersey = jerseyService.findOne(id);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id+".png";
			
			byte[] bytes = multipartFile. getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/jersey/" + fileName)));
			stream.write(bytes);
			stream.close();
			
			return new ResponseEntity("Upload Success!!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/update/image", method=RequestMethod.POST)
	public ResponseEntity updateImagePost(
			@RequestParam("id") Long id,
			HttpServletResponse response, HttpServletRequest request
			) {
		try {
			Jersey jersey = jerseyService.findOne(id);
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			Iterator<String> it = multipartRequest.getFileNames();
			MultipartFile multipartFile = multipartRequest.getFile(it.next());
			String fileName = id+".png";
			
			Files.delete(Paths.get("src/main/resources/static/image/jersey/" + fileName));
			
			byte[] bytes = multipartFile. getBytes();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/jersey/" + fileName)));
			stream.write(bytes);
			stream.close();
			
			return new ResponseEntity("Upload Success!!", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Upload failed!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping("/jerseyList")
	public List<Jersey> getJerseyList() {
		return jerseyService.findAll();
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public Jersey updateJerseyPost(@RequestBody Jersey jersey) {
		return jerseyService.save(jersey);
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public ResponseEntity remove(
			@RequestBody String id
			) throws IOException {
		jerseyService.removeOne(Long.parseLong(id));
		String fileName = id+".png";
		
		Files.delete(Paths.get("src/main/resources/static/image/jersey/" + fileName));
		
		return new ResponseEntity("Remove Success!", HttpStatus.OK);
	}
	
	@RequestMapping("/{id}")
	public Jersey getJersey(@PathVariable("id") Long id) {
		Jersey jersey = jerseyService.findOne(id);
		return jersey;
	}
}
