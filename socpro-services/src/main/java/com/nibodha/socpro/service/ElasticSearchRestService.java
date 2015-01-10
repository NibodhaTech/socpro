package com.nibodha.socpro.service;

public interface ElasticSearchRestService {
	public String createIndex(String index, String type, String json);
}
