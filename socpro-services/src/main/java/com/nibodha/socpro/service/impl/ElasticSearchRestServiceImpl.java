package com.nibodha.socpro.service.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nibodha.socpro.service.ElasticSearchRestService;
import com.nibodha.socpro.util.HttpUtil;

@Component
public class ElasticSearchRestServiceImpl implements ElasticSearchRestService {
	
	@Autowired
	private HttpUtil httpUtil;
	
	public String createIndex(String index, String type, String json){
		String url = "http://localhost:9200/"+index+"/"+type;
		try {
			return httpUtil.doPost(url, json).getResponseBody();
		} catch (IOException e) {			
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
