package com.asymmetrix.grc.riskkri.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "KRI_RISKREGISTRY_RISK_MAPPING")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class KriRiskRegistryRiskMapping extends Auditable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "KRI_RISK_MAPPING_ID")
	private long kriRiskMapId;

	@Column(name = "V_RISK_REG_ID")
	private String riskRegId;

	@Column(name = "V_DEPT_ID")
	private String deptId;

	@Column(name = "V_WORKSHOP_ID")
	private String wsId;

	@Column(name = "RISK_ID")
	private String riskId;

	@Column(name = "ACTIVE_FLAG")
	private String activeFlag;

	@Column(name = "DELETE_FLAG")
	private String deleteFlag;

	@Column(name = "KRI_ID", updatable = false)
	private String kriId;
	
	@Column(name = "UNIQUE_ID", updatable = false)
	private String kriUniqueId;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "LAST_UPDATED_BY")
	private String modifiedBy;

	public long getKriRiskMapId() {
		return kriRiskMapId;
	}

	public void setKriRiskMapId(long kriRiskMapId) {
		this.kriRiskMapId = kriRiskMapId;
	}

	public String getRiskRegId() {
		return riskRegId;
	}

	public void setRiskRegId(String riskRegId) {
		this.riskRegId = riskRegId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getWsId() {
		return wsId;
	}

	public void setWsId(String wsId) {
		this.wsId = wsId;
	}

	public String getRiskId() {
		return riskId;
	}

	public void setRiskId(String riskId) {
		this.riskId = riskId;
	}

	public String getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
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

	public String getKriId() {
		return kriId;
	}

	public void setKriId(String kriId) {
		this.kriId = kriId;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getKriUniqueId() {
		return kriUniqueId;
	}

	public void setKriUniqueId(String kriUniqueId) {
		this.kriUniqueId = kriUniqueId;
	}

	
	
}
