package com.nibodha.socpro.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class TextSentiment {
		
	private String text;	
	private String totalLines;
	private int pos;
	private int neg;
	private int mid;
	@JsonProperty("pos_percent")
	private String posPercent;
	@JsonProperty("neg_percent")
	private String negPercent;
	@JsonProperty("mid_percent")
	private String midPercent;
	private String lang;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTotalLines() {
		return totalLines;
	}
	public void setTotalLines(String totalLines) {
		this.totalLines = totalLines;
	}
	public int getPos() {
		return pos;
	}
	public void setPos(int pos) {
		this.pos = pos;
	}
	public int getNeg() {
		return neg;
	}
	public void setNeg(int neg) {
		this.neg = neg;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getPosPercent() {
		return posPercent;
	}
	public void setPosPercent(String posPercent) {
		this.posPercent = posPercent;
	}
	public String getNegPercent() {
		return negPercent;
	}
	public void setNegPercent(String negPercent) {
		this.negPercent = negPercent;
	}
	public String getMidPercent() {
		return midPercent;
	}
	public void setMidPercent(String midPercent) {
		this.midPercent = midPercent;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	@Override
	public String toString() {
		return "TextSentiment [text=" + text + ", totalLines=" + totalLines
				+ ", pos=" + pos + ", neg=" + neg + ", mid=" + mid
				+ ", posPercent=" + posPercent + ", negPercent=" + negPercent
				+ ", midPercent=" + midPercent + ", lang=" + lang + "]";
	}
	
	

}
