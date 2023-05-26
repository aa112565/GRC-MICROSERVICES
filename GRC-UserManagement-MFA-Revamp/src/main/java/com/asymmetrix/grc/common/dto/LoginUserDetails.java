package com.asymmetrix.grc.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginUserDetails {

  private String username;
  private String department;
  private String departmentType;
  private String email;
  private String phone;
  private String userLevel;

  public LoginUserDetails() {}

  public LoginUserDetails(String username, String department, String departmentType, String email,
      String phone) {
    super();
    this.username = username;
    this.department = department;
    this.departmentType = departmentType;
    this.email = email;
    this.phone = phone;
  }
  
  public LoginUserDetails(String username, String department, String departmentType, String email,
	      String phone, String userLevel) {
	    super();
	    this.username = username;
	    this.department = department;
	    this.departmentType = departmentType;
	    this.email = email;
	    this.phone = phone;
	    this.userLevel = userLevel;
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
  
  public String getUserLevel() {
		return userLevel;
  }
  public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
  }

}
