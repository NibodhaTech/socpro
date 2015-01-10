package com.nibodha.socpro.helpers.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nibodha.socpro.helpers.JsonParser;

@Component
public class JsonParserImpl implements JsonParser{
	
	public List<String> getWebsites(String json){
		List<String> websites = new ArrayList<String>();
		try {
			JsonNode arrNode = new ObjectMapper().readTree(json).get("contactInfo");
			JsonNode websiteNode = arrNode.get("websites");
			if(websiteNode.isArray()){
				for(JsonNode objNode : websiteNode){					
					System.out.println(objNode);
					websites.add(objNode.get("url").textValue());
				}
			}
//			Set<String> distinctSites = new HashSet<String>(websites);
//			websites = new ArrayList<String>(distinctSites);
			return websites;
		} catch (IOException e) {			
			e.printStackTrace();
			return null;
		}
	}
	
}
