package com.asymmetrix.grc.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizationDTO  implements Serializable {

	private static final long serialVersionUID = 1L;
		
	private String organizationName;	
	private int numberOfHierarchyLevels;	
	private String version;
	private Date createdDate;		
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;
	
	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public int getNumberOfHierarchyLevels() {
		return numberOfHierarchyLevels;
	}

	public void setNumberOfHierarchyLevels(int numberOfHierarchyLevels) {
		this.numberOfHierarchyLevels = numberOfHierarchyLevels;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}	
	

}
