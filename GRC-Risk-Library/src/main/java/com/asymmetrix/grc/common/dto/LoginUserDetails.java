package com.asymmetrix.grc.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginUserDetails {

	private String loginUserName;
	private String username;
	private String department;
	private String departmentType;
	private String email;
	private String phone;
	private String branchCode;
	private String branchName;
	private String managerId;
	private String userLevel;
	private String subordinates;

	public LoginUserDetails() {
	}

	public LoginUserDetails(String loginUserName, String username, String department, String departmentType,
			String email, String phone, String branchCode, String branchName, String managerId, String userLevel,
			String subordinates) {
		super();
		this.loginUserName = loginUserName;
		this.username = username;
		this.department = department;
		this.departmentType = departmentType;
		this.email = email;
		this.phone = phone;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.managerId = managerId;
		this.userLevel = userLevel;
		this.subordinates = subordinates;
	}

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public String getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(String subordinates) {
		this.subordinates = subordinates;
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

	@Override
	public String toString() {
		return "LoginUserDetails [loginUserName=" + loginUserName + ", username=" + username + ", department="
				+ department + ", departmentType=" + departmentType + ", email=" + email + ", phone=" + phone
				+ ", branchCode=" + branchCode + ", branchName=" + branchName + ", managerId=" + managerId
				+ ", userLevel=" + userLevel + ", subordinates=" + subordinates + "]";
	}

}
