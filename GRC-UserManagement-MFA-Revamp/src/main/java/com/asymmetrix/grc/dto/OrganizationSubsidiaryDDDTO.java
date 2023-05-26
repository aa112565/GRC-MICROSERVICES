package com.asymmetrix.grc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;

@SuppressWarnings("unused")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationSubsidiaryDDDTO {	
	
	private long subsidiaryId;
	private String subsidiaryName;
	
	
	
	
	public OrganizationSubsidiaryDDDTO(long subsidiaryId, String subsidiaryName) {
		super();
		this.subsidiaryId = subsidiaryId;
		this.subsidiaryName = subsidiaryName;
	}
	
	
	public OrganizationSubsidiaryDDDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getSubsidiaryId() {
		return subsidiaryId;
	}
	public void setSubsidiaryId(long subsidiaryId) {
		this.subsidiaryId = subsidiaryId;
	}
	public String getSubsidiaryName() {
		return subsidiaryName;
	}
	public void setSubsidiaryName(String subsidiaryName) {
		this.subsidiaryName = subsidiaryName;
	}
	
	
	
}
