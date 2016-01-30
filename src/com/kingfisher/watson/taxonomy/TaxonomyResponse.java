package com.kingfisher.watson.taxonomy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kingfisher.helpdesk.base.Taxonomy;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxonomyResponse {
	public String status;
	public String statusInfo;
	public String url;
	public String category;
	public String score;
	public Taxonomy[] taxonomy;
	
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public Taxonomy[] getTaxonomies() {
		return taxonomy;
	}
	public void setTaxonomies(Taxonomy[] taxonomies) {
		this.taxonomy = taxonomies;
	}
	
	
}
