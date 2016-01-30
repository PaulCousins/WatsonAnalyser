package com.kingfisher.helpdesk.base;

import java.util.Date;

public class Email {

	private String sender;
	private int priority;
	private String sentDateTime;
	private String subject;
	private String body;
	private Keyword[] subjectKeywords;
	private Keyword[] keywords;
	private Sentiment[] sentiment;
	private Taxonomy[] taxonomy;
	
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getSentDateTime() {
		return sentDateTime;
	}
	public void setSentDateTime(String sentDateTime) {
		this.sentDateTime = sentDateTime;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public Keyword[] getKeywords() {
		return keywords;
	}
	public void setKeywords(Keyword[] keywords) {
		this.keywords = keywords;
	}
	public Sentiment[] getSentiment() {
		return sentiment;
	}
	public void setSentiment(Sentiment[] sentiment) {
		this.sentiment = sentiment;
	}
	public Taxonomy[] getTaxonomy() {
		return taxonomy;
	}
	public void setTaxonomy(Taxonomy[] taxonomy) {
		this.taxonomy = taxonomy;
	}
	public Keyword[] getSubjectKeywords() {
		return subjectKeywords;
	}
	public void setSubjectKeywords(Keyword[] subjectKeywords) {
		this.subjectKeywords = subjectKeywords;
	}
	
	
}
