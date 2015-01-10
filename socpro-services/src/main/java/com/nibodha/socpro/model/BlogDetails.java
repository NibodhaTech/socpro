package com.nibodha.socpro.model;

import java.util.List;

public class BlogDetails {

	public BlogDetails(){}
	
	public BlogDetails(List<String> websites){
		this.blogs  = websites;
	}
	
	private List<String> blogs;

	public List<String> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<String> blogs) {
		this.blogs = blogs;
	}

	@Override
	public String toString() {
		return "BlogDetails [Blogs=" + blogs + "]";
	}
	
}
