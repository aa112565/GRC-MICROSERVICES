package com.grc.email.entity;


import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonMerge;

@Entity
@Table(name = "MST_WF_CUST_ALERT_DTL")
public class MstCustAlertDtl {
	@Id
	@Column(name = "N_SR")
	private Long srNo;
	@Column(name = "V_TYPE")
	private String type; 
	@Column(name = "V_ALERT_ID")
	private String alertId;
	@Column(name = "N_EWI_ID")
	private Integer ewiId;
	@Column(name = "V_EWI_DESC")
	private String ewiDesc;
	@Column(name = "V_SEVERITY")
	private String severity;
	@Column(name = "V_SOURCE")
	private String source;
	@Column(name = "V_FREQUENCY")
	private String frequency;
	@Column(name = "V_CUSTOMER_ID")
	private String customerId;
	@Column(name = "V_CUSTOMER_NAME")
	private String customerName;
	@Column(name = "N_CUST_EXPOSURE")
	private Long exposure;
	@Column(name = "V_CUST_CLASSIFICATION")
	private String custClassification;
	@Column(name = "V_CUST_VERTICAL")
	private String custVertical;
	@Column(name = "V_BRANCH_ID")
	private String branchId;
	@Column(name = "V_BRANCH_NAME")
	private String branchName;
	@Column(name = "V_MESSAGE")
	private String message;
	@Column(name = "D_DATE")
	private Date alertDate;
	@Column(name = "D_CLOSEBY")
	private Date closeBy;
	@Column(name = "V_STATUS")
	private String status;
	@Column(name = "V_ACTION")
	private String action;
	@Column(name = "V_STAGE")
	private String stage;
	@Column(name = "V_PAGE")
	private String page;
	@Column(name = "V_ASSIGNED_USER_ID")
	private String assignedUserId;
	@Column(name = "V_SIGNIFICANCE")
	private String significance;
	@Column(name = "V_RISK_MITIGATION")
	private String riskMitigation;
	@Column(name = "F_CLOSURE")
	private Character closureStatus;	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "N_ALERT_SR")
	@JsonMerge
	private List<AlertAudit> alertAuditList;
			
	public Character getClosureStatus() {
		return closureStatus;
	}

	public void setClosureStatus(Character closureStatus) {
		this.closureStatus = closureStatus;
	}

	public List<AlertAudit> getAlertAuditList() {
		return alertAuditList;
	}

	public void setAlertAuditList(List<AlertAudit> alertAuditList) {
		this.alertAuditList = alertAuditList;
	}

	public MstCustAlertDtl() {}
	
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
		return "MstCustAlertDtl [srNo=" + srNo + ", type=" + type + ", alertId=" + alertId + ", ewiId=" + ewiId
				+ ", ewiDesc=" + ewiDesc + ", severity=" + severity + ", source=" + source + ", frequency=" + frequency
				+ ", customerId=" + customerId + ", customerName=" + customerName + ", exposure=" + exposure
				+ ", custClassification=" + custClassification + ", custVertical=" + custVertical + ", branchId="
				+ branchId + ", branchName=" + branchName + ", message=" + message + ", alertDate=" + alertDate
				+ ", closeBy=" + closeBy + ", status=" + status + ", action=" + action + ", stage=" + stage + ", page="
				+ page + ", assignedUserId=" + assignedUserId + ", significance=" + significance + ", riskMitigation="
				+ riskMitigation + "]";
	}
	public MstCustAlertDtl(Long srNo, String type, String alertId, Integer ewiId, String ewiDesc, String severity,
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
