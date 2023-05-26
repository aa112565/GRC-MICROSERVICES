package com.asymmetrix.grc.riskkri.entity;

import java.io.File;
//import java.util.Date;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "KRI_LIBRARY_LOG")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class RiskKriLog {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "ID")
	private String id;

	@Column(name = "KRI_ID", updatable = false)
	private long kriId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String kriUniqueId;
	
	@Column(name = "ORG_NAME", updatable = false)
	private String preferenceOganization;

	@Column(name = "PREF_YEAR", updatable = false)
	private String preferenceYear;

	@Column(name = "KRI_NAME", updatable = false)
	private String kriName;

	@Column(name = "KRI_DESC", updatable = false)
	private String kriDesc;

	@Column(name = "NATURE_OF_KRI", updatable = false)
	private String natureOfKri;

	@Column(name = "RISK_INDICATOR_TYPE", updatable = false)
	private String riskIndicatorType;

	@Column(name = "ENTERPRISE_Ki", updatable = false)
	private String enterpriseKi;

	@Column(name = "KRI_APPR_STATUS", updatable = false)
	private String kriApprStatus;

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY", updatable = false)
	private String modifiedBy;
	
	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;
	
	@Column(name = "MODIFIED_DATE", nullable = false)
	private Date modifiedDate;

	@Column(name = "DELETE_FLAG", updatable = false)
	private String deleteFlag;

	@Column(name = "REMARKS", updatable = false)
	private String remarks;
	
	@Column(name = "ACTIVE_FLAG", updatable = false)
	private String activeFlag;

	@Column(name = "SUPPORT_DOC", updatable = false)
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKriUniqueId() {
		return kriUniqueId;
	}

	public void setKriUniqueId(String kriUniqueId) {
		this.kriUniqueId = kriUniqueId;
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

	
	
}
