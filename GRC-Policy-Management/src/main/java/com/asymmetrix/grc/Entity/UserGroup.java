package com.asymmetrix.grc.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PM_USERGROUP")
@NoArgsConstructor
@AllArgsConstructor
public class UserGroup {
	
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "PM_USERGROUP_ID")
	private String id;

	@Column(name = "PM_USERGROUP_NAME")
	private String usergroupName;
	
	@Column(name = "PM_USERGROUP_EMAIL")
	private String usergroupEmail;
	
	@Column(name = "STATUS")
	private String status;
	
//	@Column(name = "D_CREATED_DATE")
//	private Date createdDate;
//	
//	@Column(name = "V_CREATED_BY")
//	private String createdBy;
//	
//	@Column(name = "D_MODIFIED_DATE")
//	private Date modifiedDate;
//	
//	@Column(name = "V_MODIFIED_BY")
//	private String modifiedBy;
//	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag = "Y";
		 
	@Column(name = "DELETE_FLAG")
	private String deleteFlag = "N";

	
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
//
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
//	}
//
//	public String getCreatedBy() {
//		return createdBy;
//	}
//
//	public void setCreatedBy(String createdBy) {
//		this.createdBy = createdBy;
//	}
//
//	public Date getModifiedDate() {
//		return modifiedDate;
//	}
//
//	public void setModifiedDate(Date modifiedDate) {
//		this.modifiedDate = modifiedDate;
//	}
//
//	public String getModifiedBy() {
//		return modifiedBy;
//	}
//
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
	
	
	
	
	
	

}
