package com.nibodha.socpro.facade;

import com.nibodha.socpro.model.Blog;

public interface SocProFacade {
	public String createProfile(String email);
	public Blog getBlog();
}
