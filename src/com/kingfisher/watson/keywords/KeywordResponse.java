package com.kingfisher.watson.keywords;

import com.kingfisher.helpdesk.base.Keyword;

public class KeywordResponse {
	private String status;
	private String statusInfo;
	private String usage;
	private String language;
	private String relevance;
	private String text;
	private String sentiment;
	private String totalTransactions;
	private Keyword[] keywords;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusInfo() {
		return statusInfo;
	}
	public void setStatusInfo(String statusInfo) {
		this.statusInfo = statusInfo;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getRelevance() {
		return relevance;
	}
	public void setRelevance(String relevance) {
		this.relevance = relevance;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSentiment() {
		return sentiment;
	}
	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}
	public Keyword[] getKeywords() {
		return keywords;
	}
	public void setKeywords(Keyword[] keywords) {
		this.keywords = keywords;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getTotalTransactions() {
		return totalTransactions;
	}
	public void setTotalTransactions(String totalTransactions) {
		this.totalTransactions = totalTransactions;
	}
	

}
