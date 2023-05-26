package com.grc.email.dto;

import java.util.Date;

public class MstCustAlertDtlDTOSub {
		private Long srNo;
		private String type; 
		private String alertId;
		private Integer ewiId;
		private String ewiDesc;
		private String severity;
		private String source;
		private String frequency;
		private String customerId;
		private String customerName;
		private Long exposure;
		private String custClassification;
		private String custVertical;
		private String branchId;
		private String branchName;
		private String message;
		private Date alertDate;
		private Date closeBy;
		private String status;
		private String action;
		private String stage;
		private String page;
		private String assignedUserId;
		private String significance;
		private String riskMitigation;
		

		public MstCustAlertDtlDTOSub(){}
		
		public Long getSrNo() {
			return srNo;
		}
		public void setSrNo(Long srNo) {
			this.srNo = srNo;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getAlertId() {
			return alertId;
		}
		public void setAlertId(String alertId) {
			this.alertId = alertId;
		}
		public Integer getEwiId() {
			return ewiId;
		}
		public void setEwiId(Integer ewiId) {
			this.ewiId = ewiId;
		}
		public String getEwiDesc() {
			return ewiDesc;
		}
		public void setEwiDesc(String ewiDesc) {
			this.ewiDesc = ewiDesc;
		}
		public String getSeverity() {
			return severity;
		}
		public void setSeverity(String severity) {
			this.severity = severity;
		}
		public String getSource() {
			return source;
		}
		public void setSource(String source) {
			this.source = source;
		}
		public String getFrequency() {
			return frequency;
		}
		public void setFrequency(String frequency) {
			this.frequency = frequency;
		}
		public String getCustomerId() {
			return customerId;
		}
		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public Long getExposure() {
			return exposure;
		}
		public void setExposure(Long exposure) {
			this.exposure = exposure;
		}
		public String getCustClassification() {
			return custClassification;
		}
		public void setCustClassification(String custClassification) {
			this.custClassification = custClassification;
		}
		public String getCustVertical() {
			return custVertical;
		}
		public void setCustVertical(String custVertical) {
			this.custVertical = custVertical;
		}
		public String getBranchId() {
			return branchId;
		}
		public void setBranchId(String branchId) {
			this.branchId = branchId;
		}
		public String getBranchName() {
			return branchName;
		}
		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		public Date getAlertDate() {
			return alertDate;
		}
		public void setAlertDate(Date alertDate) {
			this.alertDate = alertDate;
		}
		public Date getCloseBy() {
			return closeBy;
		}
		public void setCloseBy(Date closeBy) {
			this.closeBy = closeBy;
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
		public String getStage() {
			return stage;
		}
		public void setStage(String stage) {
			this.stage = stage;
		}
		public String getPage() {
			return page;
		}
		public void setPage(String page) {
			this.page = page;
		}
		public String getAssignedUserId() {
			return assignedUserId;
		}
		public void setAssignedUserId(String assignedUserId) {
			this.assignedUserId = assignedUserId;
		}
		public String getSignificance() {
			return significance;
		}
		public void setSignificance(String significance) {
			this.significance = significance;
		}
		public String getRiskMitigation() {
			return riskMitigation;
		}
		public void setRiskMitigation(String riskMitigation) {
			this.riskMitigation = riskMitigation;
		}
		@Override
		public String toString() {
			return "MstCustAlertDtlDTOSub [srNo=" + srNo + ", type=" + type + ", alertId=" + alertId + ", ewiId=" + ewiId
					+ ", ewiDesc=" + ewiDesc + ", severity=" + severity + ", source=" + source + ", frequency="
					+ frequency + ", customerId=" + customerId + ", customerName=" + customerName + ", exposure="
					+ exposure + ", custClassification=" + custClassification + ", custVertical=" + custVertical
					+ ", branchId=" + branchId + ", branchName=" + branchName + ", message=" + message + ", alertDate="
					+ alertDate + ", closeBy=" + closeBy + ", status=" + status + ", action=" + action + ", stage="
					+ stage + ", page=" + page + ", assignedUserId=" + assignedUserId + ", significance=" + significance
					+ ", riskMitigation=" + riskMitigation + "]";
		}
		public MstCustAlertDtlDTOSub(Long srNo, String type, String alertId, Integer ewiId, String ewiDesc, String severity,
				String source, String frequency, String customerId, String customerName, Long exposure,
				String custClassification, String custVertical, String branchId, String branchName, String message,
				Date alertDate, Date closeBy, String status, String action, String stage, String page,
				String assignedUserId, String significance, String riskMitigation, String read) {
			super();
			this.srNo = srNo;
			this.type = type;
			this.alertId = alertId;
			this.ewiId = ewiId;
			this.ewiDesc = ewiDesc;
			this.severity = severity;
			this.source = source;
			this.frequency = frequency;
			this.customerId = customerId;
			this.customerName = customerName;
			this.exposure = exposure;
			this.custClassification = custClassification;
			this.custVertical = custVertical;
			this.branchId = branchId;
			this.branchName = branchName;
			this.message = message;
			this.alertDate = alertDate;
			this.closeBy = closeBy;
			this.status = status;
			this.action = action;
			this.stage = stage;
			this.page = page;
			this.assignedUserId = assignedUserId;
			this.significance = significance;
			this.riskMitigation = riskMitigation;
			
		}
}
