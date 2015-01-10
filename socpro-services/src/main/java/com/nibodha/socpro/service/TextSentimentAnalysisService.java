package com.nibodha.socpro.service;

import com.nibodha.socpro.model.TextSentiment;

public interface TextSentimentAnalysisService {

	public TextSentiment getTextSentimentAnalyzed(String text);
	
}
