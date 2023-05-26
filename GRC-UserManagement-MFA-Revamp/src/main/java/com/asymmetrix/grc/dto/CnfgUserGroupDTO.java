package com.asymmetrix.grc.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CnfgUserGroupDTO extends Auditable {

  private String groupId;

  private String groupName;

  private String groupDesc;

  private String landingPage;

  private String createdBy;

  private List<CnfgMenuDTO> cnfgMenu = new ArrayList<>();

  private Date createdDate;

  private Date modifiedDate;

  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  public String getGroupDesc() {
    return groupDesc;
  }

  public void setGroupDesc(String groupDesc) {
    this.groupDesc = groupDesc;
  }

  public String getLandingPage() {
    return landingPage;
  }

  public void setLandingPage(String landingPage) {
    this.landingPage = landingPage;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public List<CnfgMenuDTO> getCnfgMenu() {
    return cnfgMenu;
  }

  public void setCnfgMenu(List<CnfgMenuDTO> cnfgMenu) {
    this.cnfgMenu = cnfgMenu;
  }

  @Override
  public Date getCreatedDate() {
    return createdDate;
  }

  @Override
  public Date getModifiedDate() {
    return modifiedDate;
  }

  @Override
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  @Override
  public void setModifiedDate(Date modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  public CnfgUserGroupDTO() {

  }

  public CnfgUserGroupDTO(String groupId, String groupName, String groupDesc, String landingPage,
      String createdBy, List<CnfgMenuDTO> cnfgMenu, Date createdDate, Date modifiedDate) {
    super();
    this.groupId = groupId;
    this.groupName = groupName;
    this.groupDesc = groupDesc;
    this.landingPage = landingPage;
    this.createdBy = createdBy;
    this.cnfgMenu = cnfgMenu;
    this.createdDate = createdDate;
    this.modifiedDate = modifiedDate;
  }

}
