package com.grc.email.dto;

import java.util.Date;
import java.util.List;

import com.grc.email.entity.AuditAttachment;

public class AlertAuditDTO {
		private Long auditId;
		
		private Long alertSrNo;
		
		private String status;
		
		private String action;
		
		private String remarks;
		
		private String user;
		
		private String level;
		
		private Date when;
		
		private String userName;
		
		private List<AuditAttachment> attachments;
		
		private CnfgUserDTO cnfgUser;
						
		public CnfgUserDTO getCnfgUser() {
			return cnfgUser;
		}

		public void setCnfgUser(CnfgUserDTO cnfgUser) {
			this.cnfgUser = cnfgUser;
		}

		public List<AuditAttachment> getAttachments() {
			return attachments;
		}

		public void setAttachments(List<AuditAttachment> attachments) {
			this.attachments = attachments;
		}

		public AlertAuditDTO(){}

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

		public AlertAuditDTO(Long auditId, Long alertSrNo, String status, String action, String remarks, String user,
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
		public AlertAuditDTO(Long alertSrNo, String status, String action, String remarks, String user,
				String level, Date when) {
			super();
			this.alertSrNo = alertSrNo;
			this.status = status;
			this.action = action;
			this.remarks = remarks;
			this.user = user;
			this.level = level;
			this.when = when;
		}

		
		
		public AlertAuditDTO(Long auditId, Long alertSrNo, String status, String action, String remarks, String user,
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

		@Override
		public String toString() {
			return "AlertAuditDTO [auditId=" + auditId + ", alertSrNo=" + alertSrNo + ", status=" + status + ", action="
					+ action + ", remarks=" + remarks + ", user=" + user + ", level=" + level + ", when=" + when + "]";
		}
	
}
