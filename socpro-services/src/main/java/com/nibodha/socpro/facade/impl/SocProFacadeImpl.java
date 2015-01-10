package com.nibodha.socpro.facade.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nibodha.socpro.facade.SocProFacade;
import com.nibodha.socpro.helpers.JsonParser;
import com.nibodha.socpro.model.Blog;
import com.nibodha.socpro.model.BlogCommentsSentiment;
import com.nibodha.socpro.model.BlogDetails;
import com.nibodha.socpro.model.TextSentiment;
import com.nibodha.socpro.service.FullContactService;
import com.nibodha.socpro.service.ScrapeGoatService;
import com.nibodha.socpro.service.TextSentimentAnalysisService;
import com.nibodha.socpro.service.impl.ElasticSearchRestServiceImpl;

@Component
public class SocProFacadeImpl implements SocProFacade {

	private List<String> blogComments;

	@PostConstruct
	public void buildBlogCommentText() {
		blogComments = new ArrayList<String>();
		blogComments
				.add("This is interesting. Will get in touch with you soon");
		blogComments
				.add("I seldom leave comments on blog, but I have been to this post which was recommend by my friend, lots of valuable details, thanks again.");
		blogComments.add("Nice and thanks!");
		blogComments
				.add("Pleasant Post. This transmit helped me in my college assignment. Thnaks Alot");
		blogComments
				.add("I just added this blog site to my rss reader, excellent stuff. Cannot get enough!");
	}

	@Autowired
	private FullContactService fullContactService;

	@Autowired
	private ElasticSearchRestServiceImpl elasticSearchRestService;

	@Autowired
	private JsonParser fullContactJsonParser;

	@Autowired
	private ScrapeGoatService scrapeGoatService;

	@Autowired
	private TextSentimentAnalysisService textSentimentAnalysisService;

	public BlogDetails createProfile(String email) {
		String json = fullContactService.getContact(email);
		List<String> websites = fullContactJsonParser.getWebsites(json);
		/*
		 * TODO: This is a HACK Google Blog API returns the posts on the blog It
		 * takes 5 days for Google to send me an API Key to use Google Blog API
		 * hard-coding blog titles for the hackathon
		 */
		websites.set(0, websites.get(0)
				+ "/2009/01/building-richfaces-source-library-jars.html");
		websites.set(1, websites.get(1)
				+ "/2010/10/gephi-for-jvm-runtime-dynamics.html");
		return new BlogDetails(websites);
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

	private TextSentiment getTextSentimentAnalyzed(String text) {
		return textSentimentAnalysisService.getTextSentimentAnalyzed(text);
	}

	public BlogCommentsSentiment getBlogCommentsSentimentAnalyzed() {
		List<TextSentiment> textSentiments = new ArrayList<TextSentiment>();
		for (String comment : blogComments) {
			TextSentiment sentiment = getTextSentimentAnalyzed(comment);
			textSentiments.add(sentiment);
			System.out.println(sentiment);
		}
		int no = 0;
		double pos = 0.0;
		double neg = 0.0;
		double mid = 0.0;
		for (TextSentiment textSentiment : textSentiments) {
			String posPercent = textSentiment.getPosPercent().split("%")[0];			
			pos+=Double.parseDouble(posPercent);
			String negPercent = textSentiment.getNegPercent().split("%")[0];			
			neg+=Double.parseDouble(negPercent);
			String midPercent = textSentiment.getMidPercent().split("%")[0];			
			mid+=Double.parseDouble(midPercent);
			no++;
		}		
		return new BlogCommentsSentiment((int)Math.round(pos/no), (int)Math.round(neg/no),
				(int)Math.round(mid/no));		
	}
}
