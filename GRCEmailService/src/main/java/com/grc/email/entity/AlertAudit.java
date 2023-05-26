package com.grc.email.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonMerge;

@Entity
@Table(name = "adt_wf_alert_usr_action")
public class AlertAudit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "N_ADT_ID")
	private Long auditId;
	@Column(name = "N_ALERT_SR")
	private Long alertSrNo;
	@Column(name = "V_STATUS")
	private String status;
	@Column(name = "V_ACTION")
	private String action;
	@Column(name = "V_REMARKS")
	private String remarks;
	@Column(name = "V_USER_ID")
	private String user;
	@Column(name = "V_LEVEL")
	private String level;
	@Column(name = "D_WHEN")
	private Date when;
	@Column(name = "V_USERNAME")
	private String userName;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "N_ADT_ID")
	private List<AuditAttachment> attachments;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name="N_ALERT_SR", referencedColumnName="N_SR", insertable = false, updatable = false)
	@JsonIgnore
	private MstCustAlertDtl mstCustAlertDtl;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonMerge
	@JoinColumn(name="V_USER_ID", referencedColumnName="V_USER_ID", insertable = false, updatable = false)
	private CnfgUser cnfgUser;
					
	public CnfgUser getCnfgUser() {
		return cnfgUser;
	}

	public void setCnfgUser(CnfgUser cnfgUser) {
		this.cnfgUser = cnfgUser;
	}

	public MstCustAlertDtl getMstCustAlertDtl() {
		return mstCustAlertDtl;
	}

	public void setMstCustAlertDtl(MstCustAlertDtl mstCustAlertDtl) {
		this.mstCustAlertDtl = mstCustAlertDtl;
	}

	public List<AuditAttachment> getattachments() {
		return attachments;
	}

	public void setattachments(List<AuditAttachment> attachments) {
		this.attachments = attachments;
	}

	AlertAudit(){}

	public Long getAuditId() {
		return auditId;
	}

	public void setAuditId(Long auditId) {
		this.auditId = auditId;
	}

	public Long getAlertSrNo() {
		return alertSrNo;
	}

	public void setAlertSrNo(Long alertSrNo) {
		this.alertSrNo = alertSrNo;
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

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public AlertAudit(Long auditId, Long alertSrNo, String status, String action, String remarks, String user,
			String level, Date when) {
		super();
		this.auditId = auditId;
		this.alertSrNo = alertSrNo;
		this.status = status;
		this.action = action;
		this.remarks = remarks;
		this.user = user;
		this.level = level;
		this.when = when;
	}

	public AlertAudit(Long auditId, Long alertSrNo, String status, String action, String remarks, String user,
			String level, Date when, List<AuditAttachment> attachments) {
		super();
		this.auditId = auditId;
		this.alertSrNo = alertSrNo;
		this.status = status;
		this.action = action;
		this.remarks = remarks;
		this.user = user;
		this.level = level;
		this.when = when;
		this.attachments = attachments;
	}
	
}
