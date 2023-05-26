package com.asymmetrix.grc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationMasterDDDTO {
	
	private long organizationId;
	private String organizationName;
	
	
	public OrganizationMasterDDDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public OrganizationMasterDDDTO(long organizationId, String organizationName) {
		super();
		this.organizationId = organizationId;
		this.organizationName = organizationName;
	}



	public long getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	
}
