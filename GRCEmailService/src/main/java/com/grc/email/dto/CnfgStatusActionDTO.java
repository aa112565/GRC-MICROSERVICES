package com.grc.email.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CnfgStatusActionDTO {
	//private Integer srNo;
	private String level;
	private String levelType;
	private String status;
	private String action;
	//private String next;

	public CnfgStatusActionDTO() {}

	/*public Integer getSrNo() {
		return srNo;
	}

	public void setSrNo(Integer srNo) {
		this.srNo = srNo;
	}*/

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

	/*public String getNext() {
		return next;
	}

	public void setNext(String next) {
		this.next = next;
	}*/

	@Override
	public String toString() {
		return "CnfgStatusAction [level=" + level + ", levelType=" + levelType + ", status=" + status + ", action=" + action + "]";
		//return "CnfgStatusAction [srNo=" + srNo + ", level=" + level + ", levelType=" + levelType + ", status=" + status + ", action=" + action + ", next=" + next + "]";
	}

	public CnfgStatusActionDTO(Integer srNo, String level, String levelType, String status, String action, String next) {
		super();
		//this.srNo = srNo;
		this.level = level;
		this.levelType = levelType;
		this.status = status;
		this.action = action;
		//this.next = next;
	}
}
