package com.grc.itrisk.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssessmentAssesseeDTO {
		
	private String assessmentId;	
	private String assesseeID;		
	private String assesseeName;	
	private String departmentID;	
	private String departmentName;	
	private String assesseeEmail;
	private String active;
	private String branchName;
	
	
	
	public String getAssessmentId() {
		return assessmentId;
	}
	public void setAssessmentId(String assessmentId) {
		this.assessmentId = assessmentId;
	}
	public String getAssesseeID() {
		return assesseeID;
	}
	public void setAssesseeID(String assesseeID) {
		this.assesseeID = assesseeID;
	}
	public String getAssesseeName() {
		return assesseeName;
	}
	public void setAssesseeName(String assesseeName) {
		this.assesseeName = assesseeName;
	}
	public String getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getAssesseeEmail() {
		return assesseeEmail;
	}
	public void setAssesseeEmail(String assesseeEmail) {
		this.assesseeEmail = assesseeEmail;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	
}
