package com.grc.email.dto;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class MstCustAlertDtlDTO {
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
		private String remarks;
		private String read;
		private MultipartFile[] files;
		private String level1User;
		private String level2User;		
		private String level3User;
		private String level3UserName;
		private String level4User;
		private List<AlertAuditDTO> alertAuditList;
		private String level1UserName;
		private String level1Remarks;	
		private String level2UserName;
		private String level2Remarks;
		private String level3Remarks;
		private String recentlyAssignedUser;
		private String recentRemarks;
		private String recentlyActedUserName;
		private String recentlyActedUserId;		
		private Character closureStatus;
		private String reassignFromUserName;
		private String reassignToUserName;
		private String reassignFromUserId;
		private String reassignToUserId;
		private CnfgUserDTO reassignedManagerUserId;
		private CnfgUserDTO reassignmentInitiatedUser;
		
																										
		public CnfgUserDTO getReassignmentInitiatedUser() {
			return reassignmentInitiatedUser;
		}

		public void setReassignmentInitiatedUser(CnfgUserDTO reassignmentInitiatedUser) {
			this.reassignmentInitiatedUser = reassignmentInitiatedUser;
		}

		public CnfgUserDTO getReassignedManagerUserId() {
			return reassignedManagerUserId;
		}

		public void setReassignedManagerUserId(CnfgUserDTO reassignedManagerUserId) {
			this.reassignedManagerUserId = reassignedManagerUserId;
		}

		public String getReassignFromUserId() {
			return reassignFromUserId;
		}

		public void setReassignFromUserId(String reassignFromUserId) {
			this.reassignFromUserId = reassignFromUserId;
		}

		public String getReassignToUserId() {
			return reassignToUserId;
		}

		public void setReassignToUserId(String reassignToUserId) {
			this.reassignToUserId = reassignToUserId;
		}

		public String getReassignFromUserName() {
			return reassignFromUserName;
		}

		public void setReassignFromUserName(String reassignFromUserName) {
			this.reassignFromUserName = reassignFromUserName;
		}

		public String getReassignToUserName() {
			return reassignToUserName;
		}

		public void setReassignToUserName(String reassignToUserName) {
			this.reassignToUserName = reassignToUserName;
		}

		public Character getClosureStatus() {
			return closureStatus;
		}

		public void setClosureStatus(Character closureStatus) {
			this.closureStatus = closureStatus;
		}

		public String getRecentlyActedUserId() {
			return recentlyActedUserId;
		}

		public void setRecentlyActedUserId(String recentlyActedUserId) {
			this.recentlyActedUserId = recentlyActedUserId;
		}

		public String getRecentRemarks() {
			return recentRemarks;
		}

		public void setRecentRemarks(String recentRemarks) {
			this.recentRemarks = recentRemarks;
		}

		public String getRecentlyActedUserName() {
			return recentlyActedUserName;
		}

		public void setRecentlyActedUserName(String recentlyActedUserName) {
			this.recentlyActedUserName = recentlyActedUserName;
		}

		public String getRecentlyAssignedUser() {
			return recentlyAssignedUser;
		}

		public void setRecentlyAssignedUser(String recentlyAssignedUser) {
			this.recentlyAssignedUser = recentlyAssignedUser;
		}

		public String getLevel2UserName() {
			return level2UserName;
		}

		public void setLevel2UserName(String level2UserName) {
			this.level2UserName = level2UserName;
		}

		public String getLevel2Remarks() {
			return level2Remarks;
		}

		public void setLevel2Remarks(String level2Remarks) {
			this.level2Remarks = level2Remarks;
		}
				
		public String getLevel3Remarks() {
			return level3Remarks;
		}

		public void setLevel3Remarks(String level3Remarks) {
			this.level3Remarks = level3Remarks;
		}

		public String getLevel1UserName() {
			return level1UserName;
		}

		public void setLevel1UserName(String level1UserName) {
			this.level1UserName = level1UserName;
		}

		public String getLevel1Remarks() {
			return level1Remarks;
		}

		public void setLevel1Remarks(String level1Remarks) {
			this.level1Remarks = level1Remarks;
		}

		public List<AlertAuditDTO> getAlertAuditList() {
			return alertAuditList;
		}

		public void setAlertAuditList(List<AlertAuditDTO> alertAuditList) {
			this.alertAuditList = alertAuditList;
		}

		public MultipartFile[] getFiles() {
			return files;
		}

		public void setFiles(MultipartFile[] files) {
			this.files = files;
		}

		public String getRead() {
			return read;
		}

		public void setRead(String read) {
			this.read = read;
		}

		MstCustAlertDtlDTO(){}
		
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
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
		public String getLevel1User() {
			return level1User;
		}

		public void setLevel1User(String level1User) {
			this.level1User = level1User;
		}

		public String getLevel2User() {
			return level2User;
		}

		public void setLevel2User(String level2User) {
			this.level2User = level2User;
		}

		public String getLevel3User() {
			return level3User;
		}

		public void setLevel3User(String level3User) {
			this.level3User = level3User;
		}
				
		public String getLevel3UserName() {
			return level3UserName;
		}

		public void setLevel3UserName(String level3UserName) {
			this.level3UserName = level3UserName;
		}

		public String getLevel4User() {
			return level4User;
		}

		public void setLevel4User(String level4User) {
			this.level4User = level4User;
		}

		@Override
		public String toString() {
			return "MstCustAlertDtlDTO [srNo=" + srNo + ", type=" + type + ", alertId=" + alertId + ", ewiId=" + ewiId
					+ ", ewiDesc=" + ewiDesc + ", severity=" + severity + ", source=" + source + ", frequency="
					+ frequency + ", customerId=" + customerId + ", customerName=" + customerName + ", exposure="
					+ exposure + ", custClassification=" + custClassification + ", custVertical=" + custVertical
					+ ", branchId=" + branchId + ", branchName=" + branchName + ", message=" + message + ", alertDate="
					+ alertDate + ", closeBy=" + closeBy + ", status=" + status + ", action=" + action + ", stage="
					+ stage + ", page=" + page + ", assignedUserId=" + assignedUserId + ", significance=" + significance
					+ ", riskMitigation=" + riskMitigation + ", remarks=" + remarks + "]";
		}
		public MstCustAlertDtlDTO(Long srNo, String type, String alertId, Integer ewiId, String ewiDesc, String severity,
				String source, String frequency, String customerId, String customerName, Long exposure,
				String custClassification, String custVertical, String branchId, String branchName, String message,
				Date alertDate, Date closeBy, String status, String action, String stage, String page,
				String assignedUserId, String significance, String riskMitigation, List<AlertAuditDTO> alertAuditDTO) {
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
			this.alertAuditList = alertAuditDTO;
		}

		public MstCustAlertDtlDTO(Long srNo, String type, String alertId, Integer ewiId, String ewiDesc,
				String severity, String source, String frequency, String customerId, String customerName, Long exposure,
				String custClassification, String custVertical, String branchId, String branchName, String message,
				Date alertDate, Date closeBy, String status, String action, String stage, String page,
				String assignedUserId, String significance, String riskMitigation, String remarks, List<AlertAuditDTO> alertAuditList) {
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
			this.remarks = remarks;		
			this.alertAuditList = alertAuditList;
		}

}
