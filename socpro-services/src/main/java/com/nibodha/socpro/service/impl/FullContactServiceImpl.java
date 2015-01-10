package com.nibodha.socpro.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nibodha.socpro.service.FullContactService;
import com.nibodha.socpro.util.HttpUtil;
import com.ning.http.client.Response;

@Component
public class FullContactServiceImpl implements FullContactService {
	
	@Autowired
	private HttpUtil httpUtil;

	public String getContact(String email) {
		email = "rad.rads@gmail.com";
		String apiKey = "15779a611f991d97";
		String mashapeKey = "VssIjowCahmshHMZUAD30M7T993dp1OJPrZjsn4pUVbA65Exql";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-Mashape-Key", mashapeKey);
		Map<String, String> params = new HashMap<String, String>();
		params.put("apiKey", apiKey);		
		params.put("email", email);	
		String fullContactURL = "https://fullcontact-fullcontact.p.mashape.com/v2/person.json";
		Response rsponse = httpUtil.doGet(fullContactURL, headers, params);
		try {
			return rsponse.getResponseBody();
		} catch (IOException e) {			
			e.printStackTrace();
			return e.getMessage();
		}		
	}

}
