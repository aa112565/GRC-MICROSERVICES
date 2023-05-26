package com.asymmetrix.grc.riskkri.entity;

import java.io.File;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.ToString;

@Entity
@Table(name = "KRI_LIBRARY")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RiskKri extends Auditable {

//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE1")
//	@SequenceGenerator(name="SEQUENCE1", sequenceName="TAB_RISKLIBRARY_SEQ", allocationSize=1)

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "KRI_ID")
	private long kriId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String kriUniqueId;
	
	@Column(name = "ORG_NAME", updatable = false)
	private String preferenceOganization;

	@Column(name = "PREF_YEAR", updatable = false)
	private String preferenceYear;

	@Column(name = "KRI_NAME")
	private String kriName;

	@Column(name = "KRI_DESC")
	private String kriDesc;

	@Column(name = "NATURE_OF_KRI")
	private String natureOfKri;

	@Column(name = "RISK_INDICATOR_TYPE")
	private String riskIndicatorType;

	@Column(name = "ENTERPRISE_Ki")
	private String enterpriseKi;

	@Column(name = "KRI_APPR_STATUS")
	private String kriApprStatus;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;

	@Column(name = "REMARKS")
	private String remarks;
	
	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

	@Column(name = "SUPPORT_DOC")
	private File supportDoc;

	public long getKriId() {
		return kriId;
	}

	public String getKriName() {
		return kriName;
	}

	public String getKriDesc() {
		return kriDesc;
	}

	public String getNatureOfKri() {
		return natureOfKri;
	}

	public String getRiskIndicatorType() {
		return riskIndicatorType;
	}

	public String getEnterpriseKi() {
		return enterpriseKi;
	}

	public String getKriApprStatus() {
		return kriApprStatus;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public String getRemarks() {
		return remarks;
	}

	public File getSupportDoc() {
		return supportDoc;
	}

	public void setKriId(long kriId) {
		this.kriId = kriId;
	}

	public void setKriName(String kriName) {
		this.kriName = kriName;
	}

	public void setKriDesc(String kriDesc) {
		this.kriDesc = kriDesc;
	}

	public void setNatureOfKri(String natureOfKri) {
		this.natureOfKri = natureOfKri;
	}

	public void setRiskIndicatorType(String riskIndicatorType) {
		this.riskIndicatorType = riskIndicatorType;
	}

	public void setEnterpriseKi(String enterpriseKi) {
		this.enterpriseKi = enterpriseKi;
	}

	public void setKriApprStatus(String kriApprStatus) {
		this.kriApprStatus = kriApprStatus;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setSupportDoc(File supportDoc) {
		this.supportDoc = supportDoc;
	}

	

	public String getPreferenceOganization() {
		return preferenceOganization;
	}

	public void setPreferenceOganization(String preferenceOganization) {
		this.preferenceOganization = preferenceOganization;
	}

	public String getPreferenceYear() {
		return preferenceYear;
	}

	public void setPreferenceYear(String preferenceYear) {
		this.preferenceYear = preferenceYear;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}

	public String getKriUniqueId() {
		return kriUniqueId;
	}

	public void setKriUniqueId(String kriUniqueId) {
		this.kriUniqueId = kriUniqueId;
	}
	
	

}
