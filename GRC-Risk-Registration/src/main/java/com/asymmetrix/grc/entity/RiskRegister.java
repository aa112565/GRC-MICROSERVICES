package com.asymmetrix.grc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "RR_RISK_REGISTER", schema = "GRC_TEST_ENV_DB")
@JsonIgnoreProperties(ignoreUnknown = true)
public class RiskRegister extends Auditable {
	
	/*@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "risk_reg_seq")
	@GenericGenerator(name = "risk_reg_seq", strategy = "com.asymmetrix.grc.entity.sequence.generator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "RR_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") })*/
	@Id
	@GeneratedValue(generator ="uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "V_RISK_REG_ID")
	private String riskRegId;

	@Column(name = "V_WORKSHOP_ID")
	private String wsId;

	@Column(name = "V_DEPT_ID")
	private String deptId;
	
	
	
	@Column(name = "V_OWNER_NAME")
	private String ownerName;

	

	public RiskRegister() {
		super();
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



	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

}
