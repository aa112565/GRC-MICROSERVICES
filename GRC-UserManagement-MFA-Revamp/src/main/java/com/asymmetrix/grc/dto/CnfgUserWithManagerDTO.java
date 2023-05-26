package com.asymmetrix.grc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CnfgUserWithManagerDTO {

  private String userId;

  private String userName;

  private String email;

  private String phoneNumber;

  private String primaryBranchCode;

  private String branchCode;

  private String branchName;

  private String userLevel;

  private String managerId;

  private CnfgUserWithManagerDTO manager;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
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

  public CnfgUserWithManagerDTO getManager() {
    return manager;
  }

  public void setManager(CnfgUserWithManagerDTO manager) {
    this.manager = manager;
  }

}
