package com.nibodha.socpro.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nibodha.socpro.facade.SocProFacade;
import com.nibodha.socpro.helpers.JsonParser;
import com.nibodha.socpro.model.Blog;
import com.nibodha.socpro.service.FullContactService;
import com.nibodha.socpro.service.ScrapeGoatService;
import com.nibodha.socpro.service.impl.ElasticSearchRestServiceImpl;

@Component
public class SocProFacadeImpl implements SocProFacade {

	@Autowired
	private FullContactService fullContactService;

	@Autowired
	private ElasticSearchRestServiceImpl elasticSearchRestService;

	@Autowired
	private JsonParser fullContactJsonParser;

	@Autowired
	private ScrapeGoatService scrapeGoatService;

	public String createProfile(String email) {
		String json = fullContactService.getContact(email);
		List<String> websites = fullContactJsonParser.getWebsites(json);
		return websites.toString();
		// return //elasticSearchRestService.createIndex("socpro", "profile",
		// json);
	}

	@Override
	public Blog getBlog() {
		String url = "http://thoughtsillustrated.blogspot.in/2010/10/gephi-for-jvm-runtime-dynamics.html";
		String content = scrapeGoatService.getBlogContent(".entry", url);
		String title = scrapeGoatService.getBlogContent(".post_title", url);
		return new Blog(title, content);
	}
}
