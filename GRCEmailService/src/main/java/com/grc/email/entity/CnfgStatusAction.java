package com.grc.email.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CNFG_STATUS_ACTION")
public class CnfgStatusAction {
	@Id
	@Column(name = "N_SR")
	private Integer srNo;
	
	@Column(name = "V_LEVEL")
	private String level;
	
	@Column(name = "V_LEVEL_TYPE")
	private String levelType;
	
	@Column(name = "V_STATUS")
	private String status;
	
	@Column(name = "V_ACTION")
	private String action;
	
	@Column(name = "V_NEXT")
	private String next;

	public CnfgStatusAction() {}

	public Integer getSrNo() {
		return srNo;
	}

	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getLevelType() {
		return levelType;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "CnfgStatusAction [srNo=" + srNo + ", level=" + level + ", levelType=" + levelType + ", status=" + status
				+ ", action=" + action + ", next=" + next + "]";
	}

	public CnfgStatusAction(Integer srNo, String level, String levelType, String status, String action, String next) {
		super();
		this.srNo = srNo;
		this.level = level;
		this.levelType = levelType;
		this.status = status;
		this.action = action;
		this.next = next;
	}
	
	
}
