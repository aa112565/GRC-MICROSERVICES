package com.asymmetrix.grc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseCategoryDTO {
	
	private long responseCategoryId;
	private String responseCategory;
	
	public ResponseCategoryDTO() {		
	}
	
	public ResponseCategoryDTO(long responseCategoryId, String responseCategory) {
		this.responseCategoryId = responseCategoryId;
		this.responseCategory = responseCategory;
	}
	
	public long getResponseCategoryId() {
		return responseCategoryId;
	}
	public void setResponseCategoryId(long responseCategoryId) {
		this.responseCategoryId = responseCategoryId;
	}
	public String getResponseCategory() {
		return responseCategory;
	}
	public void setResponseCategory(String responseCategory) {
		this.responseCategory = responseCategory;
	}
}
