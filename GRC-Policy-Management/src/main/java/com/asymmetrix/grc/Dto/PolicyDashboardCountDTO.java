package com.asymmetrix.grc.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyDashboardCountDTO {
	
	
	private String Key;
	private int count;
	
	
	
	public String getKey() {
		return Key;
	}
	public void setKey(String key) {
		Key = key;
	}
	public int getCount() {
		return count;
	}
	
	
	public PolicyDashboardCountDTO() {
		super();
		
	}
	
	public PolicyDashboardCountDTO(String key, int count) {
		super();
		Key = key;
		this.count = count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	public PolicyDashboardCountDTO(Number value) {
		count = value.intValue();
    }
	
}
