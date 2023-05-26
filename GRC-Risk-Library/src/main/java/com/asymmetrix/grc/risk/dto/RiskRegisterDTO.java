package com.asymmetrix.grc.risk.dto;

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

	public RiskRegisterDTO() {
		super();
	}

	public RiskRegisterDTO(String riskRegId, String wsId, String deptId, long riskId) {
		super();
		this.riskRegId = riskRegId;
		this.wsId = wsId;
		this.deptId = deptId;
		this.riskId = riskId;
	}

	public RiskRegisterDTO(String riskRegId, String wsId, String deptId, List<Long> activeRiskIds, long riskId) {
		super();
		this.riskRegId = riskRegId;
		this.wsId = wsId;
		this.deptId = deptId;
		this.activeRiskIds = activeRiskIds;
		this.riskId = riskId;
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

}
