package com.nibodha.socpro.model;

public class Blog {
	
	public Blog(){}
	
	public Blog(String title, String content){
		this.title = title;
		this.content = content;
	}
	
	private String title;
	private String content;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Blog [title=" + title + ", content=" + content + "]";
	}
	
}
