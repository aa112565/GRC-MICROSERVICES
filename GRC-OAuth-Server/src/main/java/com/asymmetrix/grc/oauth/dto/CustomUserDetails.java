package com.asymmetrix.grc.oauth.dto;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.asymmetrix.grc.oauth.entity.CnfgUser;

public class CustomUserDetails extends User {

	private static final long serialVersionUID = 1L;

	private String loginUserName;
	private String username;
	private String department;
	private String departmentType;
	private String email;
	private String phone;
	private boolean forceChangePassword;
	private int userSessionTimeOut;
	private Date lastLogin;
	private String subordinates;
	private String managerId;
	private String branchCode;
	private String branchName;	
	private String userLevel;
	private String homePage;

	public CustomUserDetails(CnfgUser cnfgUser, List<SimpleGrantedAuthority> roles, boolean forceChangePassword,
			int userSessionTimeOut, String subordinates) {
		super(cnfgUser.getUserId(), cnfgUser.getPassword(), roles);
		this.loginUserName = cnfgUser.getUserName();
		this.username = cnfgUser.getUserId();
		this.department = cnfgUser.getDepartment();
		this.departmentType = cnfgUser.getDepartmentType();
		this.email = cnfgUser.getEmail();
		this.phone = cnfgUser.getPhoneNumber();
		this.forceChangePassword = forceChangePassword;
		this.userSessionTimeOut = userSessionTimeOut;
		this.lastLogin = cnfgUser.getLastLogin();
		this.subordinates = subordinates;
		this.managerId = cnfgUser.getManagerId();
		this.branchCode = cnfgUser.getBranchCode();
		this.branchName = cnfgUser.getBranchName();
		this.userLevel = cnfgUser.getUserLevel();
		this.homePage = cnfgUser.getCnfgUserGroup().getLandingPage();
	}
	
	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isForceChangePassword() {
		return forceChangePassword;
	}

	public void setForceChangePassword(boolean forceChangePassword) {
		this.forceChangePassword = forceChangePassword;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public int getUserSessionTimeOut() {
		return userSessionTimeOut;
	}

	public void setUserSessionTimeOut(int userSessionTimeOut) {
		this.userSessionTimeOut = userSessionTimeOut;
	}

	public String getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(String subordinates) {
		this.subordinates = subordinates;
	}
	
	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
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

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	
	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
