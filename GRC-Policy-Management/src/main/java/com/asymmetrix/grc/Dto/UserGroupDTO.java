package com.asymmetrix.grc.Dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.asymmetrix.grc.Entity.UserGroup;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGroupDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String usergroupName;
	private String usergroupEmail;
	private String status;
//	private Date createdDate;
//	private String createdBy;
//	private Date modifiedDate;
//	private String modifiedBy;
	private String activeFlag = "Y";
	private String deleteFlag = "N";
	
	private List<UserGroup> userGroup;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsergroupName() {
		return usergroupName;
	}
	public void setUsergroupName(String usergroupName) {
		this.usergroupName = usergroupName;
	}
	public String getUsergroupEmail() {
		return usergroupEmail;
	}
	public void setUsergroupEmail(String usergroupEmail) {
		this.usergroupEmail = usergroupEmail;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
//	public Date getCreatedDate() {
//		return createdDate;
//	}
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//	public String getCreatedBy() {
//		return createdBy;
//	}
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//	public Date getModifiedDate() {
//		return modifiedDate;
//	}
//	public void setModifiedDate(Date modifiedDate) {
//		this.modifiedDate = modifiedDate;
//	}
//	public String getModifiedBy() {
//		return modifiedBy;
//	}
//	public void setModifiedBy(String modifiedBy) {
//		this.modifiedBy = modifiedBy;
//	}
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
	public List<UserGroup> getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(List<UserGroup> userGroup) {
		this.userGroup = userGroup;
	}
	
	


}
