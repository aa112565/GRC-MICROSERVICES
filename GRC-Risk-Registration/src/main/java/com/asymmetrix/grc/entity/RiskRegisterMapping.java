package com.asymmetrix.grc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "RR_RISK_REGISTER_MAPPING", schema = "GRC_TEST_ENV_DB")
public class RiskRegisterMapping extends Auditable {

	@Id
	/*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "risk_reg_map_seq")
	@GenericGenerator(name = "risk_reg_map_seq", strategy = "com.asymmetrix.grc.entity.sequence.generator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "RRM_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })*/
	@GeneratedValue(generator ="uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "V_SRNO")
	private String srno;

	@Column(name = "V_RISK_REG_ID")
	private String riskRegId;

	@Column(name = "V_RISK_ID")
	private long riskId;

	@Column(name = "F_ACTIVE")
	private Character isActive;
	
	@Column(name = "V_OWNER_NAME")
	private String ownerName;

	public RiskRegisterMapping() {
		super();
	}

	public RiskRegisterMapping(String riskRegId, long riskId, Character isActive) {
		this.riskRegId = riskRegId;
		this.riskId = riskId;
		this.isActive = isActive;
	}
	
	public RiskRegisterMapping(String riskRegId, long riskId, Character isActive, String ownerName) {
		this.riskRegId = riskRegId;
		this.riskId = riskId;
		this.isActive = isActive;
		this.ownerName = ownerName;
	}

	public String getRiskRegId() {
		return riskRegId;
	}

	public void setRiskRegId(String riskRegId) {
		this.riskRegId = riskRegId;
	}

	public String getSrno() {
		return srno;
	}

	public void setSrno(String srno) {
		this.srno = srno;
	}

	public long getRiskId() {
		return riskId;
	}

	public void setRiskId(long riskId) {
		this.riskId = riskId;
	}

	public Character getIsActive() {
		return isActive;
	}

	public void setIsActive(Character isActive) {
		this.isActive = isActive;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

}
