package com.asymmetrix.grc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "RR_RISK_CONTROL_MAPPING", schema = "GRC_TEST_ENV_DB")
public class RiskControlMapping extends Auditable {

	@Id
	/*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "risk_cntrl_map_seq")
	@GenericGenerator(name = "risk_cntrl_map_seq", strategy = "com.asymmetrix.grc.entity.sequence.generator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "RCM_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })*/
	@GeneratedValue(generator ="uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "V_SRNO")
	private String srno;

	@Column(name = "V_RISK_REG_ID")
	private String riskRegId;

	@Column(name = "V_RISK_ID")
	private long riskId;

	@Column(name = "V_CONTROL_ID")
	private long controlId;

	@Column(name = "F_ACTIVE")
	private Character isActive;

	public RiskControlMapping() {
		super();
	}

	public RiskControlMapping(String riskRegId, Long riskId, Long controlId, Character isActive) {
		this.riskRegId = riskRegId;
		this.riskId = riskId;
		this.controlId = controlId;
		this.isActive = isActive;
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

	public long getControlId() {
		return controlId;
	}

	public void setControlId(long controlId) {
		this.controlId = controlId;
	}

	public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

}
