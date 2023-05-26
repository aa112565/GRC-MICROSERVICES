package com.asymmetrix.grc.entity;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonMerge;

@Entity
@Table(name = "RISK_WORKSHOP", schema = "GRC_TEST_ENV_DB")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskWorkshop extends Auditable implements Serializable {
	
	private static final long serialVersionUID = -8351864048852184625L;

	@Id
	@Column(name = "N_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="V_WORKSHOP_ID")
	private String workshopID;
	
	@Column(name = "V_WORKSHOP_NAME")
	private String workshopName;	
	
	@Column(name = "D_WORKSHOP_START_DATE")
	private Date workshopStartDate;
	
	@Column(name="D_WORKSHOP_END_DATE")
	private Date workshopEndDate;
	
	@Column(name="V_WORKSHOP_CONVENER_NAME")
	private String workshopConvenerName;
	
	@Column(name="V_WORKSHOP_AGENDA")
	private String workshopAgenda;
	
	@Column(name="V_WORKSHOP_PURPOSE")
	private String worskhopPurpose;
	
	@Column(name="N_WORKSHOP_REMINDER")
	private long workshopReminder;
	
	@Column(name = "V_STATUS")
	private String status;
	
//	@Column(name = "D_CREATED")
//	private Date createdDate;
	
	@Column(name = "V_CREATED_BY")
	private String createdBy;
	
//	@Column(name = "D_LAST_UPDATED")
//	private Date modifiedDate;
	
	@Column(name = "V_MODIFIED_BY")
	private String modifiedBy;
	
	@Column(name = "V_APPROVER_ID")
	private String approverID;
	
	@Column(name = "V_APPROVER_NAME")
	private String approverName;
	
	@Column(name="V_ACTIVE")
	private String active = "Y";
	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "V_WORKSHOP_ID", referencedColumnName = "V_WORKSHOP_ID", unique = false)
	@JsonMerge
	private Set<RiskWorkshopParticipants> participantList = new HashSet<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWorkshopID() {
		return workshopID;
	}

	public void setWorkshopID(String workshopID) {
		this.workshopID = workshopID;
	}

	public String getWorkshopName() {
		return workshopName;
	}

	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

	public Date getWorkshopStartDate() {
		return workshopStartDate;
	}

	public void setWorkshopStartDate(Date workshopStartDate) {
		this.workshopStartDate = workshopStartDate;
	}

	public Date getWorkshopEndDate() {
		return workshopEndDate;
	}

	public void setWorkshopEndDate(Date workshopEndDate) {
		this.workshopEndDate = workshopEndDate;
	}

	public String getWorkshopConvenerName() {
		return workshopConvenerName;
	}

	public void setWorkshopConvenerName(String workshopConvenerName) {
		this.workshopConvenerName = workshopConvenerName;
	}

	public String getWorkshopAgenda() {
		return workshopAgenda;
	}

	public void setWorkshopAgenda(String workshopAgenda) {
		this.workshopAgenda = workshopAgenda;
	}

	public String getWorskhopPurpose() {
		return worskhopPurpose;
	}

	public void setWorskhopPurpose(String worskhopPurpose) {
		this.worskhopPurpose = worskhopPurpose;
	}

	public long getWorkshopReminder() {
		return workshopReminder;
	}

	public void setWorkshopReminder(long workshopReminder) {
		this.workshopReminder = workshopReminder;
	}

	public Set<RiskWorkshopParticipants> getParticipantList() {
		return participantList;
	}

	public void setParticipantList(Set<RiskWorkshopParticipants> participantList) {
		this.participantList = participantList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
/*
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
*/
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
/*
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
*/
	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getApproverID() {
		return approverID;
	}

	public void setApproverID(String approverID) {
		this.approverID = approverID;
	}

	public String getApproverName() {
		return approverName;
	}

	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}


}
