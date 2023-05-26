package com.grc.email.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CNFG_USER_GROUP")
public class CnfgUserGroup implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "V_GROUP_ID")
  private String groupId;

  @Column(name = "V_GROUP_NAME")
  private String groupName;

  @Column(name = "V_GROUP_DESC")
  private String groupDesc;

  @Column(name = "V_LANDING_PAGE")
  private String landingPage;

  @Column(name = "V_CREATED_BY")
  private String createdBy;

  @OneToMany(cascade = CascadeType.PERSIST)
  @JoinTable(name = "CNFG_GROUP_ROLES",
      joinColumns = @JoinColumn(name = "V_GROUP_ID", referencedColumnName = "V_GROUP_ID"),
      inverseJoinColumns = @JoinColumn(name = "V_ROLE_NAME", referencedColumnName = "V_ROLE_NAME",
          unique = true))

  private List<CnfgMenu> cnfgMenu = new ArrayList<>();

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

  public List<CnfgMenu> getCnfgMenu() {
    return cnfgMenu;
  }

  public void setCnfgMenu(List<CnfgMenu> cnfgMenu) {
    this.cnfgMenu = cnfgMenu;
  }

  public CnfgUserGroup() {}

  public CnfgUserGroup(String groupId, String groupName, String groupDesc, String landingPage,
      String createdBy, List<CnfgMenu> cnfgMenu) {
    super();
    this.groupId = groupId;
    this.groupName = groupName;
    this.groupDesc = groupDesc;
    this.landingPage = landingPage;
    this.createdBy = createdBy;
    this.cnfgMenu = cnfgMenu;
  }

}
