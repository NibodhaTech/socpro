package com.nibodha.socpro.model;


public class BlogCommentsSentiment {

	public BlogCommentsSentiment(){}				
	
	public BlogCommentsSentiment(int posPercent, int negPercent, int midPercent) {		
		this.posPercent = posPercent;
		this.negPercent = negPercent;
		this.midPercent = midPercent;
	}

	private int posPercent;
	private int negPercent;
	private int midPercent;
	
	public int getPosPercent() {
		return posPercent;
	}

	public void setPosPercent(int posPercent) {
		this.posPercent = posPercent;
	}

	public int getNegPercent() {
		return negPercent;
	}

	public void setNegPercent(int negPercent) {
		this.negPercent = negPercent;
	}

	public int getMidPercent() {
		return midPercent;
	}

	public void setMidPercent(int midPercent) {
		this.midPercent = midPercent;
	}

	@Override
	public String toString() {
		return "BlogCommentsSentiment [posPercent=" + posPercent
				+ ", negPercent=" + negPercent + ", midPercent=" + midPercent
				+ "]";
	}

	
}
