package com.asymmetrix.grc.Dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.asymmetrix.grc.Entity.User;
import com.asymmetrix.grc.Entity.UserGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PolicyCollaborateDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
    private long collabrateId;
	private String[] users;
	private Date dueDate;
	private String comments;
	private String[] userGroup;
	private String PolicyId;
	private String activeFlag = "Y";
	private String deleteFlag = "N";
	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;
	private String collabrateFlag;
	
	public long getCollabrateId() {
		return collabrateId;
	}
	public void setCollabrateId(long collabrateId) {
		this.collabrateId = collabrateId;
	}
	
	public String[] getUsers() {
		return users;
	}
	public void setUsers(String[] users) {
		this.users = users;
	}
	public String[] getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String[] userGroup) {
		this.userGroup = userGroup;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getPolicyId() {
		return PolicyId;
	}
	public void setPolicyId(String policyId) {
		PolicyId = policyId;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getDeleteFlag() {
		return deleteFlag;
	}
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
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
	public String getCollabrateFlag() {
		return collabrateFlag;
	}
	public void setCollabrateFlag(String collabrateFlag) {
		this.collabrateFlag = collabrateFlag;
	}
	
	
	

}
