package com.asymmetrix.grc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CNFG_PROPERTY_DETAILS")
public class CnfgPropertyDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "N_CNFG_ID")
  private int cnfgId;

  @Column(name = "V_CNFG_KEY")
  private String cnfgKey;

  @Column(name = "V_CNFG_VALUE")
  private String cnfgValue;

  @Column(name = "V_CNFG_NAME")
  private String cnfgName;

  public int getCnfgId() {
    return cnfgId;
  }

  public void setCnfgId(int cnfgId) {
    this.cnfgId = cnfgId;
  }

  public String getCnfgKey() {
    return cnfgKey;
  }

  public void setCnfgKey(String cnfgKey) {
    this.cnfgKey = cnfgKey;
  }

  public String getCnfgValue() {
    return cnfgValue;
  }

  public void setCnfgValue(String cnfgValue) {
    this.cnfgValue = cnfgValue;
  }

  public String getCnfgName() {
    return cnfgName;
  }

  public void setCnfgName(String cnfgName) {
    this.cnfgName = cnfgName;
  }

  public CnfgPropertyDetails(int cnfgId, String cnfgKey, String cnfgValue, String cnfgName) {
    super();
    this.cnfgId = cnfgId;
    this.cnfgKey = cnfgKey;
    this.cnfgValue = cnfgValue;
    this.cnfgName = cnfgName;
  }

  public CnfgPropertyDetails() {
    super();
  }

}
