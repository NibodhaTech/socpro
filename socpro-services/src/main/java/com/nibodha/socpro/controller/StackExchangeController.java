package com.nibodha.socpro.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nibodha.socpro.util.HttpUtil;
import com.ning.http.client.Response;

@Controller
@RequestMapping("/stackoverflow")
public class StackExchangeController {

	@Autowired
	private HttpUtil httpUtil;
	
	@RequestMapping("/user/{name}")
	@ResponseBody
	public String getStackOverflowUser(@PathParam("name") String username){
//		RestTemplate restTemplate = new RestTemplate();
//		String stackOverflowURL = "http://api.stackexchange.com/2.2/users?order=desc&sort=reputation&inname="+username+"&site=stackoverflow";
//		String anishUrl = "http://207bd6c7.ngrok.com/user/setkey/anish";
		String stackOverflowURL = "http://api.stackexchange.com/2.2/users";		
////		ResponseEntity<String[]> json = restTemplate.getForEntity(stackOverflowURL,String[].class);
//		String json = restTemplate.getForObject(/*stackOverflowURL*/anishUrl,String.class);
//		//json.replaceAll("[\\x00-\\x09\\x11\\x12\\x14-\\x1F\\x7F]", "");
//		return json;
//		return json.getBody().toString();
		Map<String, String> params = new HashMap<String, String>();
		params.put("order", "desc");
		params.put("sort", "reputation");
		params.put("inname", username);
		params.put("site", "stackoverflow");
		Response response = httpUtil.doGet(stackOverflowURL, params);
		try {
			System.out.println(response.getResponseBody());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "success";
//		ResponseEntity<String> response = restTemplate.getForEntity(stackOverflowURL, String.class, params);
//		System.out.println(response.getBody());
//		return response.getBody();			
	}
		
	
}
