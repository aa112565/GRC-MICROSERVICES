package com.asymmetrix.grc.dto;

import java.util.Date;

import com.asymmetrix.grc.common.aspect.MaskUserField;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@SuppressWarnings("unused")
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CnfgUserDTO {

  private String userId;
  
  //revamp changes
  private String userNameFirst;
  
  private String userNameLast;
  //

  private String userName;

  private String password;

  private char accountActive;

  private char accountDeleted;

  private String homePage;

  private String locale;
  
  @MaskUserField
  private String email;

  private String address;
 
  @MaskUserField
  private String phoneNumber;

  private int sessionTime;

  private int allowedAttempt;

  private int passExipryDays;

  private int failedAttempt;

  private Date lastLogin;

  private int defaultDashBoard;
  
  //revamp changes
  private String organizationCode;
  
  private String organizationName;
  
  private String departmentCode;
  //

  private String department;

  private String departmentType;

  private String reportCurrency;

  private int reportUnit;

  private String otpEnable;

  private String businessSegment;

  private String primaryBranchCode;

  private String branchCode;

  private String branchName;

  private String location;

  private String region;

  private String zone;

  private String grade;

  private Date createdDate;

  private Date modifiedDate;

  private String userLevel;

  private String managerId;

  private CnfgUserGroupDTO cnfgUserGroup = new CnfgUserGroupDTO();

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

  public char getAccountActive() {
    return accountActive;
  }

  public void setAccountActive(char accountActive) {
    this.accountActive = accountActive;
  }

  public char getAccountDeleted() {
    return accountDeleted;
  }

  public void setAccountDeleted(char accountDeleted) {
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

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public CnfgUserGroupDTO getCnfgUserGroup() {
    return cnfgUserGroup;
  }

  public void setCnfgUserGroup(CnfgUserGroupDTO cnfgUserGroup) {
    this.cnfgUserGroup = cnfgUserGroup;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public Date getModifiedDate() {
    return modifiedDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
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

public CnfgUserDTO() {
    super();
  }
  
  public CnfgUserDTO(String userId, String userName, String userNameFirst, String userNameLast, String email, String phoneNumber) {
	    this.userId = userId;
	    this.userName = userName;
	    this.userNameFirst = userNameFirst;
		this.userNameLast = userNameLast;
	    this.email = email;
	    this.phoneNumber = phoneNumber;
  }  

  public CnfgUserDTO(String userId, String userName, String password, char accountActive,
      char accountDeleted, String homePage, String locale, String email, String address,
      String phoneNumber, int sessionTime, int allowedAttempt, int passExipryDays,
      int failedAttempt, Date lastLogin, int defaultDashBoard, String department,
      String departmentType, String reportCurrency, int reportUnit, String otpEnable,
      String businessSegment, String primaryBranchCode, String branchCode, String branchName,
      String location, String region, String zone, String grade, Date createdDate,
      Date modifiedDate, String userLevel, String managerId, CnfgUserGroupDTO cnfgUserGroup) {
    super();
    this.userId = userId;
    this.userName = userName;
    this.password = password;
    this.accountActive = accountActive;
    this.accountDeleted = accountDeleted;
    this.homePage = homePage;
    this.locale = locale;
    this.email = email;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.sessionTime = sessionTime;
    this.allowedAttempt = allowedAttempt;
    this.passExipryDays = passExipryDays;
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
    this.createdDate = createdDate;
    this.modifiedDate = modifiedDate;
    this.userLevel = userLevel;
    this.managerId = managerId;
    this.cnfgUserGroup = cnfgUserGroup;
  }

public CnfgUserDTO(String userId, String userNameFirst, String userNameLast, String userName, String password,
		char accountActive, char accountDeleted, String homePage, String locale, String email, String address,
		String phoneNumber, int sessionTime, int allowedAttempt, int passExipryDays, int failedAttempt, Date lastLogin,
		int defaultDashBoard, String organizationCode, String organizationName, String departmentCode,
		String department, String departmentType, String reportCurrency, int reportUnit, String otpEnable,
		String businessSegment, String primaryBranchCode, String branchCode, String branchName, String location,
		String region, String zone, String grade, Date createdDate, Date modifiedDate, String userLevel,
		String managerId, CnfgUserGroupDTO cnfgUserGroup) {
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
	this.sessionTime = sessionTime;
	this.allowedAttempt = allowedAttempt;
	this.passExipryDays = passExipryDays;
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
	this.createdDate = createdDate;
	this.modifiedDate = modifiedDate;
	this.userLevel = userLevel;
	this.managerId = managerId;
	this.cnfgUserGroup = cnfgUserGroup;
}

/*
@Override
public String toString() {
	return "CnfgUserDTO [userId=" + userId + ", userNameFirst=" + userNameFirst + ", userNameLast=" + userNameLast
			+ ", userName=" + userName + ", password=" + password + ", accountActive=" + accountActive
			+ ", accountDeleted=" + accountDeleted + ", homePage=" + homePage + ", locale=" + locale + ", email="
			+ email + ", address=" + address + ", phoneNumber=" + phoneNumber + ", sessionTime=" + sessionTime
			+ ", allowedAttempt=" + allowedAttempt + ", passExipryDays=" + passExipryDays + ", failedAttempt="
			+ failedAttempt + ", lastLogin=" + lastLogin + ", defaultDashBoard=" + defaultDashBoard
			+ ", organizationCode=" + organizationCode + ", organizationName=" + organizationName + ", departmentCode="
			+ departmentCode + ", department=" + department + ", departmentType=" + departmentType + ", reportCurrency="
			+ reportCurrency + ", reportUnit=" + reportUnit + ", otpEnable=" + otpEnable + ", businessSegment="
			+ businessSegment + ", primaryBranchCode=" + primaryBranchCode + ", branchCode=" + branchCode
			+ ", branchName=" + branchName + ", location=" + location + ", region=" + region + ", zone=" + zone
			+ ", grade=" + grade + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", userLevel="
			+ userLevel + ", managerId=" + managerId + ", cnfgUserGroup=" + cnfgUserGroup + "]";
	}
*/
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("CnfgUserModel [userId=").append(userId).append(", userName=").append(userName)
    	.append(", userNameFirst=").append(userNameFirst)
    	.append(", userNameLast=").append(userNameLast)
        .append(", accountActive=").append(accountActive).append(", accountDeleted=")
        .append(accountDeleted).append(", homePage=").append(homePage).append(", locale=")
        .append(locale).append(", email=").append(email).append(", address=").append(address)
        .append(", phoneNumber=").append(phoneNumber).append(", sessionTime=").append(sessionTime)
        .append(", allowedAttempt=").append(allowedAttempt).append(", passExipryDays=")
        .append(passExipryDays).append(", failedAttempt=").append(failedAttempt)
        .append(", lastLogin=").append(lastLogin).append(", defaultDashBoard=")
        .append(defaultDashBoard).append(", department=").append(department)
        .append(", organizationCode=").append(organizationCode)
    	.append(", organizationName=").append(organizationName)
    	.append(", departmentCode=").append(departmentCode)
        .append(", departmentType=").append(departmentType).append(", reportCurrency=")
        .append(reportCurrency).append(", reportUnit=").append(reportUnit).append(", otpEnable=")
        .append(otpEnable).append(", businessSegment=").append(businessSegment)
        .append(", primaryBranchCode=").append(primaryBranchCode).append(", branchCode=")
        .append(branchCode).append(", branchName=").append(branchName).append(", location=")
        .append(location).append(", region=").append(region).append(", zone=").append(zone)
        .append(", grade=").append(grade).append(", createdDate=").append(createdDate)
        .append(", modifiedDate=").append(modifiedDate).append(", userLevel=").append(userLevel)
        .append(", managerId=").append(managerId).append(", cnfgUserGroup=").append(cnfgUserGroup)
        .append("]");
    return builder.toString();
  }
  
 

}
