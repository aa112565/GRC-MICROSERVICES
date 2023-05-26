package com.asymmetrix.grc.riskkri.dto;

import java.io.File;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class KRIWithBusinessLineDTO {

	private long kriId;
	private String kriUniqueId;
	private String kriName;
	private String kriDesc;
	private String natureOfKri;
	private String riskIndicatorType;
	private String enterpriseKi;
	private String kriApprStatus;
	private String buninessLineOne;
	private String buninessLineTwo;

	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;
	private String deleteFlag;
	private String remarks;

	private File supportDoc;

	public long getKriId() {
		return kriId;
	}

	public void setKriId(long kriId) {
		this.kriId = kriId;
	}

	public String getKriName() {
		return kriName;
	}

	public void setKriName(String kriName) {
		this.kriName = kriName;
	}

	public String getKriDesc() {
		return kriDesc;
	}

	public void setKriDesc(String kriDesc) {
		this.kriDesc = kriDesc;
	}

	public String getNatureOfKri() {
		return natureOfKri;
	}

	public void setNatureOfKri(String natureOfKri) {
		this.natureOfKri = natureOfKri;
	}

	public String getRiskIndicatorType() {
		return riskIndicatorType;
	}

	public void setRiskIndicatorType(String riskIndicatorType) {
		this.riskIndicatorType = riskIndicatorType;
	}

	public String getEnterpriseKi() {
		return enterpriseKi;
	}

	public void setEnterpriseKi(String enterpriseKi) {
		this.enterpriseKi = enterpriseKi;
	}

	public String getKriApprStatus() {
		return kriApprStatus;
	}

	public void setKriApprStatus(String kriApprStatus) {
		this.kriApprStatus = kriApprStatus;
	}

	public String getBuninessLineOne() {
		return buninessLineOne;
	}

	public void setBuninessLineOne(String buninessLineOne) {
		this.buninessLineOne = buninessLineOne;
	}

	public String getBuninessLineTwo() {
		return buninessLineTwo;
	}

	public void setBuninessLineTwo(String buninessLineTwo) {
		this.buninessLineTwo = buninessLineTwo;
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

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public File getSupportDoc() {
		return supportDoc;
	}

	public void setSupportDoc(File supportDoc) {
		this.supportDoc = supportDoc;
	}

	public String getKriUniqueId() {
		return kriUniqueId;
	}

	public void setKriUniqueId(String kriUniqueId) {
		this.kriUniqueId = kriUniqueId;
	}
	

}
