package com.nibodha.socpro.service.impl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nibodha.socpro.model.TextSentiment;
import com.nibodha.socpro.service.TextSentimentAnalysisService;
import com.nibodha.socpro.util.HttpUtil;
import com.ning.http.client.Response;

@Component
public class TextSentimentAnalysisServiceImpl implements
		TextSentimentAnalysisService {

	@Autowired
	private HttpUtil httpUtil;

	public TextSentiment getTextSentimentAnalyzed(String text) {
		String mashapeKey = "MFWxp6etOCmshXYj5WX2J3G67UZrp1FKhgSjsnWYdvgfy2XqFz";
		String url = "https://text-sentiment.p.mashape.com/analyze";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("X-Mashape-Key", mashapeKey);
		headers.put("Content-Type", "application/x-www-form-urlencoded");
		Map<String, String> params = new HashMap<String, String>();
		params.put("text", text);
		Response response = httpUtil.doPost(url, headers, params);
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			TextSentiment textSentiment = objectMapper.readValue(
					response.getResponseBodyAsBytes(), TextSentiment.class);
			return textSentiment;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
