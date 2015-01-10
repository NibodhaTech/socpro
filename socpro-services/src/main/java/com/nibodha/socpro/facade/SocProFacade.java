package com.nibodha.socpro.facade;

import com.nibodha.socpro.model.Blog;
import com.nibodha.socpro.model.BlogCommentsSentiment;
import com.nibodha.socpro.model.BlogDetails;
import com.nibodha.socpro.model.TextSentiment;

public interface SocProFacade {
	public BlogDetails createProfile(String email);
	public Blog getBlog();
	public BlogCommentsSentiment getBlogCommentsSentimentAnalyzed();
}
