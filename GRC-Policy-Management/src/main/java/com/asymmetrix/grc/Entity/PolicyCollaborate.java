package com.asymmetrix.grc.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonMerge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "PM_POLICY_COLLABRATE")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class PolicyCollaborate implements Serializable {   
	
	private static final long serialVersionUID = 1L; 

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@JsonInclude(Include.NON_NULL)
	@Column(name = "PM_COLLABRATEID")
	private long collabrateId;
	
	
//	@JoinTable(name = "PM_POLICY_CREATION",
//		    joinColumns = {@JoinColumn(name = "PM_PolicyID")},
//		    inverseJoinColumns = {@JoinColumn(name = "PM_PolicyID")})
	@Column(name = "PM_PolicyID")
	private String PolicyId;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "PM_COLLABRATEID", referencedColumnName = "PM_COLLABRATEID", unique = false)
//	@JsonMerge
//	@Column(name = "PM_COLLABRATE_USERSGROUP")
//	private Set<UserGroup> UserGroup = new HashSet<>();
	@Column(name = "PM_COLLABRATE_USERSGROUP")
	private String UserGroup[];
	
	
	@Column(name = "PM_COLLABRATE_USERS")
	private String users[];
	
	@Column(name = "PM_COLLABRATE_DUEDATE")
	private Date dueDate;
	
	@Column(name = "PM_COLLABRATE_COMMENTS")
	private String comments;
	
	@Column(name = "D_CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "V_CREATED_BY")
	private String createdBy;
	
	@Column(name = "D_MODIFIED_DATE")
	private Date modifiedDate;
	
	@Column(name = "V_MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag = "Y";
		 
	@Column(name = "DELETE_FLAG")
	private String deleteFlag = "N";
	
	@Column(name = "COLLABRATE_FLAG")
	private String collabrateFlag;
	
	public long getCollabrateId() {
		return collabrateId;
	}

	public void setCollabrateId(long collabrateId) {
		this.collabrateId = collabrateId;
	}
	
	
	public void setCollabrateId(Long collabrateId) {
		this.collabrateId = collabrateId;
	}
	

	public String[] getUserGroup() {
		return UserGroup;
	}

	public void setUserGroup(String[] userGroup) {
		UserGroup = userGroup;
	}

	public String[] getUsers() {
		return users;
	}

	public void setUsers(String[] users) {
		this.users = users;
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

	public String getPolicyId() {
		return PolicyId;
	}

	public void setPolicyId(String policyId) {
		PolicyId = policyId;
	}

	public String getCollabrateFlag() {
		return collabrateFlag;
	}

	public void setCollabrateFlag(String collabrateFlag) {
		this.collabrateFlag = collabrateFlag;
	}
	
	


	
	
	
	
}
