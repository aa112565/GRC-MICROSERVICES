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
@Table(name = "ITRISK_ASSESSMEMT_ASSESSORS")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssessmentAssessors implements Serializable{
	
//	private static final long serialVersionUID = -5818525642697324673L;

	@Id
	@Column(name = "N_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "V_ASSESSOR_ID")
	private String assessorID;	
	
	@Column(name = "V_ASSESSOR_NAME")
	private String assessorName;
	
	@Column(name="V_DEPARTMENT_ID")
	private String departmentID;
	
	@Column(name="V_DEPARTMENT_NAME")
	private String departmentName;
	
	@Column(name="V_ASSESSOR_EMAIL")
	private String assessorEmail;
	
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

	public String getAssessorID() {
		return assessorID;
	}

	public void setAssessorID(String assessorID) {
		this.assessorID = assessorID;
	}

	public String getAssessorName() {
		return assessorName;
	}

	public void setAssessorName(String assessorName) {
		this.assessorName = assessorName;
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

	public String getAssessorEmail() {
		return assessorEmail;
	}

	public void setAssessorEmail(String assessorEmail) {
		this.assessorEmail = assessorEmail;
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
