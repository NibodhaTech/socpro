package com.nibodha.socpro.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nibodha.socpro.service.ScrapeGoatService;
import com.nibodha.socpro.util.HttpUtil;
import com.ning.http.client.Response;

@Component
public class ScrapeGoatServiceImpl implements ScrapeGoatService {

	@Autowired
	private HttpUtil httpUtil;

	public String getBlogContent(String selector, String url) {
		System.out.println("Selector : " + selector);
		System.out.println("url : " + url);
		String mashapeKey = "MFWxp6etOCmshXYj5WX2J3G67UZrp1FKhgSjsnWYdvgfy2XqFz";
		String content = null;
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-Mashape-Key", mashapeKey);
		Map<String, String> params = new HashMap<String, String>();
		params.put("selector", selector);
		// params.put("timeout", String.valueOf(3000));		
		params.put("url", url);
		String scrapeGoatURL = "https://scrapegoat.p.mashape.com/prerendered/";
		Response response = httpUtil.doGet(scrapeGoatURL, headers, params);
		try {
			System.out.println("Response : " + response.getResponseBody());
			return response.getResponseBody();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
