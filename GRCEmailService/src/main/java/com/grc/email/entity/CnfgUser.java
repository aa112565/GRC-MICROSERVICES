package com.grc.email.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CNFG_USERS")
public class CnfgUser implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "V_USER_ID")
	private String userId;

	@Column(name = "V_USERNAME")
	private String userName;

	@Column(name = "V_PASSWORD")
	private String password;

	@Column(name = "V_ACCOUNT_ACTIVE")
	private Character accountActive;

	@Column(name = "V_ACCOUNT_DELETED")
	private Character accountDeleted;

	@Column(name = "V_HOME_PAGE")
	private String homePage;

	@Column(name = "V_LOCALE")
	private String locale;

	@Column(name = "V_EMAIL")
	private String email;

	@Column(name = "V_ADDRESS")
	private String address;

	@Column(name = "V_PHONE")
	private String phoneNumber;

	@Column(name = "D_PASSWORD_CHANGED_DATE")
	private Date passwordChangedDate;

	@Column(name = "N_SESSION_TIME")
	private int sessionTime;

	@Column(name = "N_ALLOWED_ATTEMPT")
	private int allowedAttempt;

	@Column(name = "N_PASS_EXPIRY_DAYS")
	private int passExipryDays;

	@Column(name = "V_PASSWORD2")
	private String password2;

	@Column(name = "V_PASSWORD3")
	private String password3;

	@Column(name = "N_FAILED_ATTEMPT")
	private int failedAttempt;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "D_LAST_LOGIN")
	private Date lastLogin;

	@Column(name = "N_DEFAULT_DASHBOARD")
	private int defaultDashBoard;

	@Column(name = "V_DEPARTMENT")
	private String department;

	@Column(name = "V_DEPARTMENT_TYPE")
	private String departmentType;

	@Column(name = "V_REPORT_CURRENCY")
	private String reportCurrency;

	@Column(name = "N_REPORT_UNIT")
	private int reportUnit;

	@Column(name = "V_OTP_ENABLED")
	private String otpEnable;

	@Column(name = "V_BUSINESS_SEGMENT")
	private String businessSegment;

	@Column(name = "V_PRIMARY_BRANCH_CODE")
	private String primaryBranchCode;

	@Column(name = "V_BRANCH_CODE")
	private String branchCode;

	@Column(name = "V_BRANCH_NAME")
	private String branchName;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "REGION")
	private String region;

	@Column(name = "ZONE")
	private String zone;

	@Column(name = "GRADE")
	private String grade;

	@Column(name = "v_user_level")
	private String userLevel;

	@Column(name = "v_manager_id")
	private String managerId;

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Character getAccountActive() {
		return accountActive;
	}

	public void setAccountActive(Character accountActive) {
		this.accountActive = accountActive;
	}

	public Character getAccountDeleted() {
		return accountDeleted;
	}

	public void setAccountDeleted(Character accountDeleted) {
		this.accountDeleted = accountDeleted;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getPasswordChangedDate() {
		return passwordChangedDate;
	}

	public void setPasswordChangedDate(Date passwordChangedDate) {
		this.passwordChangedDate = passwordChangedDate;
	}

	public int getSessionTime() {
		return sessionTime;
	}

	public void setSessionTime(int sessionTime) {
		this.sessionTime = sessionTime;
	}

	public int getAllowedAttempt() {
		return allowedAttempt;
	}

	public void setAllowedAttempt(int allowedAttempt) {
		this.allowedAttempt = allowedAttempt;
	}

	public int getPassExipryDays() {
		return passExipryDays;
	}

	public void setPassExipryDays(int passExipryDays) {
		this.passExipryDays = passExipryDays;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getPassword3() {
		return password3;
	}

	public void setPassword3(String password3) {
		this.password3 = password3;
	}

	public int getFailedAttempt() {
		return failedAttempt;
	}

	public void setFailedAttempt(int failedAttempt) {
		this.failedAttempt = failedAttempt;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getDefaultDashBoard() {
		return defaultDashBoard;
	}

	public void setDefaultDashBoard(int defaultDashBoard) {
		this.defaultDashBoard = defaultDashBoard;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartmentType() {
		return departmentType;
	}

	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}

	public String getReportCurrency() {
		return reportCurrency;
	}

	public void setReportCurrency(String reportCurrency) {
		this.reportCurrency = reportCurrency;
	}

	public int getReportUnit() {
		return reportUnit;
	}

	public void setReportUnit(int reportUnit) {
		this.reportUnit = reportUnit;
	}

	public String getOtpEnable() {
		return otpEnable;
	}

	public void setOtpEnable(String otpEnable) {
		this.otpEnable = otpEnable;
	}

	public String getBusinessSegment() {
		return businessSegment;
	}

	public void setBusinessSegment(String businessSegment) {
		this.businessSegment = businessSegment;
	}

	public String getPrimaryBranchCode() {
		return primaryBranchCode;
	}

	public void setPrimaryBranchCode(String primaryBranchCode) {
		this.primaryBranchCode = primaryBranchCode;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	

	public CnfgUser() {
	}
	
	public CnfgUser(String userId, String userName, String email, String department, String departmentType,
			String managerId, String branchCode, String userLevel) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.department = department;
		this.departmentType = departmentType;
		this.managerId = managerId;
		this.branchCode = branchCode;
		this.userLevel = userLevel;		
	}

}
