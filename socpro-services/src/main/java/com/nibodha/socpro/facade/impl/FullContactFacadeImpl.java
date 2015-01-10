package com.nibodha.socpro.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nibodha.socpro.facade.FullContactFacade;
import com.nibodha.socpro.service.FullContactService;
import com.nibodha.socpro.service.impl.ElasticSearchRestServiceImpl;

@Component
public class FullContactFacadeImpl implements FullContactFacade {

	@Autowired
	private FullContactService fullContactService;
	
	@Autowired
	private ElasticSearchRestServiceImpl elasticSearchRestService;
	
	public String createProfile(String email){
		String json = fullContactService.getContact(email);
		return elasticSearchRestService.createIndex("socpro", "profile", json);
	}
	
}
