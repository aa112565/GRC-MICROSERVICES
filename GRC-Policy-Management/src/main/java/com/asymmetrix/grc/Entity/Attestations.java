package com.asymmetrix.grc.Entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "PM_POLICY_ATTESTATIONS")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class Attestations implements Serializable {    // implements Serializable 
	
	private static final long serialVersionUID = 1L; 
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@JsonInclude(Include.NON_NULL)
	@Column(name = "PM_ATTESTATIONS_ID")
	private long attestaionsId;
	
	@Column(name = "PM_PolicyID")
	private String PolicyId;
	
	@Column(name = "PM_AGREEMENT")
	private String agreement;
	
	@Column(name = "PM_ATT_DUEDATE")
	private Date duedate;
	
	@Column(name = "PM_EXPIRYDATE")
	private Date expirydate;
	
	@Column(name = "PM_USERGROUPS")
	private String usergroups[];
	
	@Column(name = "PM_USER")
	private String user[];
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag = "Y";
		 
	@Column(name = "DELETE_FLAG")
	private String deleteFlag = "N";
	
	@Column(name = "D_CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "V_CREATED_BY")
	private String createdBy;
	
	@Column(name = "D_MODIFIED_DATE")
	private Date modifiedDate;
	
	@Column(name = "V_MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "PM_ALERT_MESSAGE")
	private String alertMessage;

	public long getAttestaionsId() {
		return attestaionsId;
	}

	public void setAttestaionsId(long attestaionsId) {
		this.attestaionsId = attestaionsId;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public Date getDuedate() {
		return duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	

	public String[] getUsergroups() {
		return usergroups;
	}

	public void setUsergroups(String[] usergroups) {
		this.usergroups = usergroups;
	}

	public String[] getUser() {
		return user;
	}

	public void setUser(String[] user) {
		this.user = user;
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

	public String getAlertMessage() {
		return alertMessage;
	}

	public void setAlertMessage(String alertMessage) {
		this.alertMessage = alertMessage;
	}
	
	
	

}
