package com.asymmetrix.asset.common.aspect.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "NTF_AUDIT_LOG")
public class AuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "N_AUDIT_CD")
	private long auditCode;

	@Column(name = "V_USER_ID")
	private String userId;

	@Column(name = "V_ACTION")
	private String action;

	@Column(name = "V_IP_ADDRESS")
	private String ipAddress;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "T_TIME", nullable = false, updatable = false)
	private Date createdTime;

	@Column(name = "V_MSG")
	private String message;

	@Column(name = "V_ACTION_RESULT")
	private String actionResult;

	public long getAuditCode() {
		return auditCode;
	}

	public void setAuditCode(long auditCode) {
		this.auditCode = auditCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getActionResult() {
		return actionResult;
	}

	public void setActionResult(String actionResult) {
		this.actionResult = actionResult;
	}

}
