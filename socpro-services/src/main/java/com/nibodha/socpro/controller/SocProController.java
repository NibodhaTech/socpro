package com.nibodha.socpro.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
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
	public BlogDetails getBlogDetails(@PathParam("email") String email) {				
		return socProFacade.createProfile(email);		
	}
	
	@RequestMapping("/blog")
	@ResponseBody
	public Blog getBlog() {				
		return socProFacade.getBlog();		
	}
	
	@RequestMapping("/blog/{email}/sentiment")
	@ResponseBody
	public BlogCommentsSentiment getSentiments(@PathParam("email") String email) {		
		return socProFacade.getBlogCommentsSentimentAnalyzed();		
	}
	
}
