package com.kingfisher.watson.sentiment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kingfisher.helpdesk.base.Sentiment;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SentimentResponse {
	public String status;
	public String statusInfo;
	public String usage;
	public String language;
	public String text;
	public Sentiment docSentiment;
	
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
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Sentiment getDocSentiment() {
		return docSentiment;
	}
	public void setDocSentiment(Sentiment docSentiment) {
		this.docSentiment = docSentiment;
	}

}
