package com.asymmetrix.grc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.asymmetrix.grc.entity.converter.AttributeCipherConverter;

@Entity
@Table(name = "CNFG_USERS")
public class CnfgUser extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "V_USER_ID", updatable = false)
	private String userId;

	// revamp changes
	@Column(name = "V_USERNAME_FIRST")
	private String userNameFirst;

	@Column(name = "V_USERNAME_LAST")
	private String userNameLast;
	//

	@Column(name = "V_USERNAME")
	private String userName;

	@Column(name = "V_PASSWORD", updatable = false)
	private String password;

	@Column(name = "V_ACCOUNT_ACTIVE")
	private Character accountActive;

	@Column(name = "V_ACCOUNT_DELETED")
	private Character accountDeleted;

	@Column(name = "V_HOME_PAGE")
	private String homePage;

	@Column(name = "V_LOCALE")
	private String locale;

	@Convert(converter = AttributeCipherConverter.class)
//  @Convert(converter = HashingAttributeConverter.class)
	// @Convert(converter = MaskingAttributeConverter.class)
	@Column(name = "V_EMAIL")
	private String email;
	
	// revamp changes
		@Column(name = "V_ORG_CODE")
		private String organizationCode;

		@Column(name = "V_ORG_NAME")
		private String organizationName;

		@Column(name = "V_DEPARTMENT_CODE")
		private String departmentCode;
		//	

//@Convert(converter = HashingAttributeConverter.class)
	// @Convert(converter = MaskingAttributeConverter.class)
	@Column(name = "V_ADDRESS")
	private String address;

//  @Convert(converter = HashingAttributeConverter.class)
	// @Convert(converter = MaskingAttributeConverter.class)
	@Convert(converter = AttributeCipherConverter.class)
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

	@Column(name = "D_LAST_LOGIN", updatable = false)
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

	@OneToOne(targetEntity = CnfgUserGroup.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "V_GROUP_ID")
	private CnfgUserGroup cnfgUserGroup;

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

	public CnfgUserGroup getCnfgUserGroup() {
		return cnfgUserGroup;
	}

	public void setCnfgUserGroup(CnfgUserGroup cnfgUserGroup) {
		this.cnfgUserGroup = cnfgUserGroup;
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

	public String getUserNameFirst() {
		return userNameFirst;
	}

	public void setUserNameFirst(String userNameFirst) {
		this.userNameFirst = userNameFirst;
	}

	public String getUserNameLast() {
		return userNameLast;
	}

	public void setUserNameLast(String userNameLast) {
		this.userNameLast = userNameLast;
	}

	public String getOrganizationCode() {
		return organizationCode;
	}

	public void setOrganizationCode(String organizationCode) {
		this.organizationCode = organizationCode;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public CnfgUser() {
	}

	public CnfgUser(String userId, String userName, String userNameFirst, String userNameLast, String email,
			String organizationCode, String organizationName, String departmentCode, String department,
			String departmentType, Character accountActive, Character accountDeleted, String primaryBranchCode,
			String branchCode, String branchName, String phoneNumber, String grade, Date createdDate, Date modifiedDate,
			Date lastLogin, String managerId, String userLevel, String homePage, CnfgUserGroup cnfgUserGroup) {

		this.userId = userId;
		this.userName = userName;

		this.userNameFirst = userNameFirst;
		this.userNameLast = userNameLast;

		this.email = email;

		this.organizationCode = organizationCode;
		this.organizationName = organizationName;
		this.departmentCode = departmentCode;

		this.department = department;
		this.departmentType = departmentType;
		this.accountActive = accountActive;
		this.accountDeleted = accountDeleted;
		this.primaryBranchCode = primaryBranchCode;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.phoneNumber = phoneNumber;
		this.grade = grade;
		this.setCreatedDate(createdDate);
		this.setModifiedDate(modifiedDate);
		this.setLastLogin(lastLogin);
		this.managerId = managerId;
		this.userLevel = userLevel;
		this.homePage = homePage;
		this.cnfgUserGroup = cnfgUserGroup;
	}

	public CnfgUser(String userId, String userName, String userNameFirst, String userNameLast, String email, String organizationCode,
			String organizationName, String departmentCode, String department, String departmentType, Character accountActive, Character accountDeleted, String primaryBranchCode,
			String branchCode, String branchName, String phoneNumber, String grade, Date createdDate, Date modifiedDate,
			Date lastLogin, String location, String region, String zone, String managerId, String userLevel, 
			CnfgUserGroup cnfgUserGroup) {
		this.userId = userId;
		this.userName = userName;

		this.userNameFirst = userNameFirst;
		this.userNameLast = userNameLast;

		this.email = email;

		this.organizationCode = organizationCode;
		this.organizationName = organizationName;
		this.departmentCode = departmentCode;

		this.department = department;
		this.departmentType = departmentType;
		this.accountActive = accountActive;
		this.accountDeleted = accountDeleted;
		this.primaryBranchCode = primaryBranchCode;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.phoneNumber = phoneNumber;
		this.grade = grade;
		this.setCreatedDate(createdDate);
		this.setModifiedDate(modifiedDate);
		this.setLastLogin(lastLogin);
		
		this.location = location;
		this.region = region;
		this.zone = zone;
		
		this.managerId = managerId;
		this.userLevel = userLevel;
		this.cnfgUserGroup = cnfgUserGroup;
	}

	public CnfgUser(String userId, String userName, String userNameFirst, String userNameLast, String password,
			Character accountActive, Character accountDeleted, String homePage, String locale, String email,
			String organizationCode, String organizationName, String departmentCode, String address, String phoneNumber,
			Date passwordChangedDate, int sessionTime, int allowedAttempt, int passExipryDays, String password2,
			String password3, int failedAttempt, Date lastLogin, int defaultDashBoard, String department,
			String departmentType, String reportCurrency, int reportUnit, String otpEnable, String businessSegment,
			String primaryBranchCode, String branchCode, String branchName, String location, String region, String zone,
			String grade, String userLevel, String managerId, CnfgUserGroup cnfgUserGroup) {
		super();
		this.userId = userId;
		this.userName = userName;
		// this.password = password;

		this.userNameFirst = userNameFirst;
		this.userNameLast = userNameLast;

		this.accountActive = accountActive;
		this.accountDeleted = accountDeleted;
		this.homePage = homePage;
		this.locale = locale;
		this.email = email;

		this.organizationCode = organizationCode;
		this.organizationName = organizationName;
		this.departmentCode = departmentCode;

		this.address = address;
		this.phoneNumber = phoneNumber;
		this.passwordChangedDate = passwordChangedDate;
		this.sessionTime = sessionTime;
		this.allowedAttempt = allowedAttempt;
		this.passExipryDays = passExipryDays;
		this.password2 = password2;
		this.password3 = password3;
		this.failedAttempt = failedAttempt;
		this.lastLogin = lastLogin;
		this.defaultDashBoard = defaultDashBoard;
		this.department = department;
		this.departmentType = departmentType;
		this.reportCurrency = reportCurrency;
		this.reportUnit = reportUnit;
		this.otpEnable = otpEnable;
		this.businessSegment = businessSegment;
		this.primaryBranchCode = primaryBranchCode;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.location = location;
		this.region = region;
		this.zone = zone;
		this.grade = grade;
		this.userLevel = userLevel;
		this.managerId = managerId;
		this.cnfgUserGroup = cnfgUserGroup;
	}
/*
	public CnfgUser(String userId, String userNameFirst, String userNameLast, String userName, String password,
			Character accountActive, Character accountDeleted, String homePage, String locale, String email,
			String address, String phoneNumber, Date passwordChangedDate, int sessionTime, int allowedAttempt,
			int passExipryDays, String password2, String password3, int failedAttempt, Date lastLogin,
			int defaultDashBoard, String organizationCode, String organizationName, String departmentCode,
			String department, String departmentType, String reportCurrency, int reportUnit, String otpEnable,
			String businessSegment, String primaryBranchCode, String branchCode, String branchName, String location,
			String region, String zone, String grade, String userLevel, String managerId, CnfgUserGroup cnfgUserGroup) {
		super();
		this.userId = userId;
		this.userNameFirst = userNameFirst;
		this.userNameLast = userNameLast;
		this.userName = userName;
		this.password = password;
		this.accountActive = accountActive;
		this.accountDeleted = accountDeleted;
		this.homePage = homePage;
		this.locale = locale;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.passwordChangedDate = passwordChangedDate;
		this.sessionTime = sessionTime;
		this.allowedAttempt = allowedAttempt;
		this.passExipryDays = passExipryDays;
		this.password2 = password2;
		this.password3 = password3;
		this.failedAttempt = failedAttempt;
		this.lastLogin = lastLogin;
		this.defaultDashBoard = defaultDashBoard;
		this.organizationCode = organizationCode;
		this.organizationName = organizationName;
		this.departmentCode = departmentCode;
		this.department = department;
		this.departmentType = departmentType;
		this.reportCurrency = reportCurrency;
		this.reportUnit = reportUnit;
		this.otpEnable = otpEnable;
		this.businessSegment = businessSegment;
		this.primaryBranchCode = primaryBranchCode;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.location = location;
		this.region = region;
		this.zone = zone;
		this.grade = grade;
		this.userLevel = userLevel;
		this.managerId = managerId;
		this.cnfgUserGroup = cnfgUserGroup;
	}
*/
}
