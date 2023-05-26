package com.grc.itrisk.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("serial")
@Entity
@Table(name = "ITRISK_ASSESSMEMT_ASSESSEE")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssessmentAssessee implements Serializable{
	
//	private static final long serialVersionUID = -5818525642697324673L;

	@Id
	@Column(name = "N_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "V_ASSESSEE_ID")
	private String assesseeID;	
	
	@Column(name = "V_ASSESSEE_NAME")
	private String assesseeName;
	
	@Column(name="V_DEPARTMENT_ID")
	private String departmentID;
	
	@Column(name="V_DEPARTMENT_NAME")
	private String departmentName;
	
	@Column(name="V_ASSESSEE_EMAIL")
	private String assesseeEmail;
	
	@Column(name = "V_ACTIVE")
	private String active = "Y";
	
	@Column(name = "ASSESSMENT_ID")
	private long assessmentId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public long getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(long assessmentId) {
		this.assessmentId = assessmentId;
	}

	
	
}
