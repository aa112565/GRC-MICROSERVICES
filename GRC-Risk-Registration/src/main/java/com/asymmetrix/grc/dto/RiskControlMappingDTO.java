package com.asymmetrix.grc.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskControlMappingDTO {

	private String srno;
	private String riskRegId;
	private long riskId;
	private List<Long> controlIds;

	public RiskControlMappingDTO() {
		super();
	}

	public RiskControlMappingDTO(String riskRegId, Long riskId, List<Long> controlIds) {
		this.riskRegId = riskRegId;
		this.riskId = riskId;
		this.controlIds = controlIds;
	}

	public String getSrno() {
		return srno;
	}

	public void setSrno(String srno) {
		this.srno = srno;
	}

	public String getRiskRegId() {
		return riskRegId;
	}

	public void setRiskRegId(String riskRegId) {
		this.riskRegId = riskRegId;
	}

	public long getRiskId() {
		return riskId;
	}

	public void setRiskId(long riskId) {
		this.riskId = riskId;
	}

	public List<Long> getControlIds() {
		return controlIds;
	}

	public void setControlIds(List<Long> controlIds) {
		this.controlIds = controlIds;
	}

}
