package com.grc.itrisk.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@SuppressWarnings("unused")
@Entity
@Table(name = "ITRISK_TEMPLATE_CONTROL_LOG")
public class TemplateControlLog extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "LOG_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long logId;		
	
	@Column(name = "N_ID")
	private long templateControlId;
	
	@Column(name = "V_TEMPLATE_ID")
	private long templateId;

	@Column(name = "V_TEMPLATE_NO")
	private String templateNo;

	@Column(name = "V_TEMPLATE_DOMAIN")
	private String templateDomain;
	
	@Column(name = "V_ANNEX_DETAILS")
	private String annexDetails;
	
	@Column(name = "V_CONTROL_OBJECTIVE")
	private String controlObjective;
	
	@Column(name = "V_CONTROL")
	private String control;
	
	@Column(name = "V_CONTROL_ID")
	private String controlId;
		
	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;
	
	 @Column(name = "D_CREATED")
	 private Date createdDate;
	 
	 @Column(name = "D_LAST_UPDATED")
	 private Date modifiedDate;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;
	
	@Column(name = "SAVE_FLAG")
	private String saveFlag;
	
	@Column(name = "V_REMARKS")
	private String remarks;

	public long getLogId() {
		return logId;
	}

	public void setLogId(long logId) {
		this.logId = logId;
	}

	
	public long getTemplateControlId() {
		return templateControlId;
	}

	public void setTemplateControlId(long templateControlId) {
		this.templateControlId = templateControlId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getSaveFlag() {
		return saveFlag;
	}

	public void setSaveFlag(String saveFlag) {
		this.saveFlag = saveFlag;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}

	public String getTemplateNo() {
		return templateNo;
	}

	public void setTemplateNo(String templateNo) {
		this.templateNo = templateNo;
	}

	public String getTemplateDomain() {
		return templateDomain;
	}

	public void setTemplateDomain(String templateDomain) {
		this.templateDomain = templateDomain;
	}

	public String getAnnexDetails() {
		return annexDetails;
	}

	public void setAnnexDetails(String annexDetails) {
		this.annexDetails = annexDetails;
	}

	public String getControlObjective() {
		return controlObjective;
	}

	public void setControlObjective(String controlObjective) {
		this.controlObjective = controlObjective;
	}

	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public String getControlId() {
		return controlId;
	}

	public void setControlId(String controlId) {
		this.controlId = controlId;
	}

	
}
