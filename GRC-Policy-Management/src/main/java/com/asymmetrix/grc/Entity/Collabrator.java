package com.asymmetrix.grc.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "PM_POLICY_COLLABRATOR")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Collabrator implements Serializable  {    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@JsonInclude(Include.NON_NULL)
	@Column(name = "PM_COLLABRATORID")
	private long collabratorId;
	
	
	@Column(name = "PM_PolicyID", updatable = false)
	private String policyId;
	
	@Column(name = "PM_COLLABRATEID",updatable = false)
	private String collabrateId;
	
	@Column(name = "PM_ATTESTATIONS_ID",updatable = false)
	private String attestaionsId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String policyUniqueId;
	
	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "PM_APPROVE")
	private String approve ;
	
	@Column(name = "PM_REJECT")
	private String reject;
	
	@Column(name = "D_CREATED_DATE")
	private Date createdDate;
	
	@Column(name = "V_CREATED_BY")
	private String createdBy;
	
	@Column(name = "D_MODIFIED_DATE")
	private Date modifiedDate;
	
	@Column(name = "V_MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;
		 
	@Column(name = "DELETE_FLAG")
	private String deleteFlag;

	public long getCollabratorId() {
		return collabratorId;
	}

	public void setCollabratorId(long collabratorId) {
		this.collabratorId = collabratorId;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getCollabrateId() {
		return collabrateId;
	}

	public void setCollabrateId(String collabrateId) {
		this.collabrateId = collabrateId;
	}

	public String getAttestaionsId() {
		return attestaionsId;
	}

	public void setAttestaionsId(String attestaionsId) {
		this.attestaionsId = attestaionsId;
	}

	public String getPolicyUniqueId() {
		return policyUniqueId;
	}

	public void setPolicyUniqueId(String policyUniqueId) {
		this.policyUniqueId = policyUniqueId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public String getReject() {
		return reject;
	}

	public void setReject(String reject) {
		this.reject = reject;
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

	
	
	
	

}
