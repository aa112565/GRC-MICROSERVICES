package com.asymmetrix.grc.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskWorkshopDTO {
		
	private String workshopID;
	private String workshopName;	
	private Date workshopStartDate;	
	private Date workshopEndDate;	
	private String workshopConvenerName;	
	private String workshopAgenda;	
	private String worskhopPurpose;	
	private long workshopReminder;	
	private String status;	
	private Date createdDate;	
	private String createdBy;	
	private Date modifiedDate;	
	private String modifiedBy;	
	private String approverID;	
	private String approverName;
	private String active;
	private List<RiskWorkshopParticipantsDTO> participantList = new ArrayList<>();
	
	private String branchName;
	
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

	public List<RiskWorkshopParticipantsDTO> getParticipantList() {
		return participantList;
	}

	public void setParticipantList(List<RiskWorkshopParticipantsDTO> participantList) {
		this.participantList = participantList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
}
