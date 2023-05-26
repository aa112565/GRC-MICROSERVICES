package com.asymmetrix.grc.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskRegisterDTO {

	private String riskRegId;
	private String wsId;
	private String deptId;
	private List<Long> activeRiskIds;
	private long riskId;	
	private String createdBy;
	private String modifiedBy;
	private String ownerName;

	public RiskRegisterDTO() {
		super();
	}
	
	public RiskRegisterDTO(String riskRegId, String wsId, String deptId) {
		super();
		this.riskRegId = riskRegId;
		this.wsId = wsId;
		this.deptId = deptId;	
	}
	
	public RiskRegisterDTO(String riskRegId, String wsId, String deptId, String ownerName) {
		super();
		this.riskRegId = riskRegId;
		this.wsId = wsId;
		this.deptId = deptId;
		this.ownerName = ownerName;
	}
	
	public RiskRegisterDTO(String riskRegId, String wsId, String deptId, String createdBy, String modifiedBy, String ownerName) {
		super();
		this.riskRegId = riskRegId;
		this.wsId = wsId;
		this.deptId = deptId;	
		this.ownerName = ownerName;
		
		this.createdBy = createdBy;	
		this.modifiedBy = modifiedBy;	
	}

	public RiskRegisterDTO(String riskRegId, String wsId, String deptId, long riskId) {
		super();
		this.riskRegId = riskRegId;
		this.wsId = wsId;
		this.deptId = deptId;
		this.riskId = riskId;
	}
	

	public RiskRegisterDTO(String riskRegId, String wsId, String deptId, long riskId, String ownerName) {
		super();
		this.riskRegId = riskRegId;
		this.wsId = wsId;
		this.deptId = deptId;
		this.riskId = riskId;
		this.ownerName = ownerName;
	}
	
	public RiskRegisterDTO(String riskRegId, String wsId, String deptId, long riskId,  String createdBy, String modifiedBy, String ownerName) {
		super();
		this.riskRegId = riskRegId;
		this.wsId = wsId;
		this.deptId = deptId;
		this.riskId = riskId;
	
		this.createdBy = createdBy;	
		this.modifiedBy = modifiedBy;
		this.ownerName = ownerName;
	}

	public RiskRegisterDTO(String riskRegId, String wsId, String deptId, List<Long> activeRiskIds) {
		super();
		this.riskRegId = riskRegId;
		this.wsId = wsId;
		this.deptId = deptId;
		this.activeRiskIds = activeRiskIds;
		
	}
	
	public RiskRegisterDTO(String riskRegId, String wsId, String deptId, List<Long> activeRiskIds, String ownerName) {
		super();
		this.riskRegId = riskRegId;
		this.wsId = wsId;
		this.deptId = deptId;
		this.activeRiskIds = activeRiskIds;
		this.ownerName = ownerName;
	}
	
	public RiskRegisterDTO(String riskRegId, String wsId, String deptId, List<Long> activeRiskIds,  String createdBy, String modifiedBy) {
		super();
		this.riskRegId = riskRegId;
		this.wsId = wsId;
		this.deptId = deptId;
		this.activeRiskIds = activeRiskIds;
		
		this.createdBy = createdBy;	
		this.modifiedBy = modifiedBy;
	}


	public RiskRegisterDTO(String riskRegId, List<Long> riskId) {
		super();
		this.riskRegId = riskRegId;
		this.activeRiskIds = riskId;
	}

	public String getRiskRegId() {
		return riskRegId;
	}

	public void setRiskRegId(String riskRegId) {
		this.riskRegId = riskRegId;
	}

	public String getWsId() {
		return wsId;
	}

	public void setWsId(String wsId) {
		this.wsId = wsId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public List<Long> getActiveRiskIds() {
		return activeRiskIds;
	}

	public void setActiveRiskIds(List<Long> activeRiskIds) {
		this.activeRiskIds = activeRiskIds;
	}


	public long getRiskId() {
		return riskId;
	}


	public void setRiskId(long riskId) {
		this.riskId = riskId;
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

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

}
