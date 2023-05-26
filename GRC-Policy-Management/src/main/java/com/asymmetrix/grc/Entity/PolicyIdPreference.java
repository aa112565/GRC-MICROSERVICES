package com.asymmetrix.grc.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "PM_LIB_ID_PREFERENCE_2" )
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
//@JsonIgnoreProperties(ignoreUnknown = true)
@ComponentScan
public class PolicyIdPreference extends Auditable  {    
	 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCEAUDIT")
//	@SequenceGenerator(name = "SEQUENCEAUDIT", sequenceName = "AUDIT_SEQUENCE", allocationSize = 1)
	@Column(name = "SERIES_ID")
	private long seriesId;
	
	@Column(name = "ORG_NAME")
	private String preferenceOganization;

	@Column(name = "PRE_YEAR")
	private String preferenceYear;

	@Column(name = "PRE_MODULE")
	private String preferenceModule;
	
	@Column(name = "RUNNING_SERIES")
	private String runningSeries;
	
	@Column(name = "STATUS")
	private String status;

	@Column(name = "CREATED_BY", updatable = false)
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;
	
//	@Column(name = "D_CREATED_DATE")
//	private Date createdDate;
//
//	@Column(name = "D_MODIFIED_DATE")
//	private Date modifiedDate;
	
	public long getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(long seriesId) {
		this.seriesId = seriesId;
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

	public String getPreferenceModule() {
		return preferenceModule;
	}

	public void setPreferenceModule(String preferenceModule) {
		this.preferenceModule = preferenceModule;
	}

	public String getRunningSeries() {
		return runningSeries;
	}

	public void setRunningSeries(String runningSeries) {
		this.runningSeries = runningSeries;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

//	public Date getCreatedDate() {
//		return createdDate;
//	}
//
//	public void setCreatedDate(Date createdDate) {
//		this.createdDate = createdDate;
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
	
	
	
}
