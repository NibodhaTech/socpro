package com.nibodha.socpro.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nibodha.socpro.facade.FullContactFacade;

@Controller
@RequestMapping("/fullcontact")
public class FullContactController {
	
	@Autowired
	private FullContactFacade fullContactFacade;
	
	@RequestMapping("/details/{email}")
	@ResponseBody
	public String getFullContactDetails(@PathParam("email") String email) {				
		return fullContactFacade.createProfile(email);		
	}
	
}
