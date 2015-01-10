package com.nibodha.socpro.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nibodha.socpro.facade.SocProFacade;
import com.nibodha.socpro.model.Blog;
import com.nibodha.socpro.model.BlogCommentsSentiment;
import com.nibodha.socpro.model.BlogDetails;

@Controller
@RequestMapping("/socpro")
public class SocProController {	
	
	@Autowired
	private SocProFacade socProFacade;
	
	@RequestMapping("/blogs/{email}")
	@ResponseBody
	public ResponseEntity<BlogDetails> getBlogDetails(@PathParam("email") String email) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With");
		headers.add("Access-Control-Allow-Methods", "GET, PUT, POST");
		ResponseEntity<BlogDetails> response = new ResponseEntity<BlogDetails>(socProFacade.createProfile(email), headers, HttpStatus.OK);
		return response;		
	}
	
	@RequestMapping("/blog")
	@ResponseBody
	public Blog getBlog() {				
		return socProFacade.getBlog();		
	}
	
	@RequestMapping("/blog/{email}/sentiment")
	@ResponseBody
	public ResponseEntity<BlogCommentsSentiment> getSentiments(@PathParam("email") String email) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Headers", "Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With");
		headers.add("Access-Control-Allow-Methods", "GET, PUT, POST");
		ResponseEntity<BlogCommentsSentiment> response = new ResponseEntity<BlogCommentsSentiment>(socProFacade.getBlogCommentsSentimentAnalyzed(), headers, HttpStatus.OK);
		return response;					
	}
	
}
