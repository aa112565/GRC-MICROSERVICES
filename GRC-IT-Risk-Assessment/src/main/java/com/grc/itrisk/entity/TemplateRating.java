package com.grc.itrisk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITRISK_TEMPLATE_RATING")
public class TemplateRating extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "N_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long templateRatingId;
	
	@Column(name = "V_TEMPLATE_ID")
	private long templateId;

	@Column(name = "V_NOT_APPLICABLE")
	private String notApplicable;
	
	@Column(name = "V_NON_COMPLIANT")
	private String nonCompliant;	
	
	@Column(name = "V_PARTIALLY_COMPLIANT")
	private String partiallyCompliant;	
	
	@Column(name = "V_COMPLIANT_WITH_DOCUMENT")
	private String compliantWithDocuments;	
	
	@Column(name = "V_COMPLIANT_WITHOT_DOCUMENT")
	private String compliantWithoutDocuments;	
	
	@Column(name = "V_NOT_APPLICABLE_LABEL")
	private String notApplicableLable;
	
	@Column(name = "V_NON_COMPLIANT_LABEL")
	private String nonCompliantLable;	
	
	@Column(name = "V_PARTIALLY_COMPLIANT_LABEL")
	private String partiallyCompliantLable;	
	
	@Column(name = "V_COMPLIANT_WITH_DOCUMENT_LABEL")
	private String compliantWithDocumentsLable;	
	
	@Column(name = "V_COMPLIANT_WITHOT_DOCUMENT_LABEL")
	private String compliantWithoutDocumentsLable;	

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;
	
	@Column(name = "SAVE_FLAG")
	private String saveFlag;
	
	@Column(name = "V_REMARKS")
	private String remarks;
	


	public long getTemplateRatingId() {
		return templateRatingId;
	}

	public void setTemplateRatingId(long templateRatingId) {
		this.templateRatingId = templateRatingId;
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

	public String getNotApplicable() {
		return notApplicable;
	}

	public void setNotApplicable(String notApplicable) {
		this.notApplicable = notApplicable;
	}

	public String getNonCompliant() {
		return nonCompliant;
	}

	public void setNonCompliant(String nonCompliant) {
		this.nonCompliant = nonCompliant;
	}

	public String getPartiallyCompliant() {
		return partiallyCompliant;
	}

	public void setPartiallyCompliant(String partiallyCompliant) {
		this.partiallyCompliant = partiallyCompliant;
	}

	public String getCompliantWithDocuments() {
		return compliantWithDocuments;
	}

	public void setCompliantWithDocuments(String compliantWithDocuments) {
		this.compliantWithDocuments = compliantWithDocuments;
	}

	public String getCompliantWithoutDocuments() {
		return compliantWithoutDocuments;
	}

	public void setCompliantWithoutDocuments(String compliantWithoutDocuments) {
		this.compliantWithoutDocuments = compliantWithoutDocuments;
	}

	public String getNotApplicableLable() {
		return notApplicableLable;
	}

	public void setNotApplicableLable(String notApplicableLable) {
		this.notApplicableLable = notApplicableLable;
	}

	public String getNonCompliantLable() {
		return nonCompliantLable;
	}

	public void setNonCompliantLable(String nonCompliantLable) {
		this.nonCompliantLable = nonCompliantLable;
	}

	public String getPartiallyCompliantLable() {
		return partiallyCompliantLable;
	}

	public void setPartiallyCompliantLable(String partiallyCompliantLable) {
		this.partiallyCompliantLable = partiallyCompliantLable;
	}

	public String getCompliantWithDocumentsLable() {
		return compliantWithDocumentsLable;
	}

	public void setCompliantWithDocumentsLable(String compliantWithDocumentsLable) {
		this.compliantWithDocumentsLable = compliantWithDocumentsLable;
	}

	public String getCompliantWithoutDocumentsLable() {
		return compliantWithoutDocumentsLable;
	}

	public void setCompliantWithoutDocumentsLable(String compliantWithoutDocumentsLable) {
		this.compliantWithoutDocumentsLable = compliantWithoutDocumentsLable;
	}

	
}
