package com.asymmetrix.grc.dto;

public class CnfgPropertyDetailsDTO {

  private int cnfgId;

  private String cnfgKey;

  private String cnfgValue;

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

  public CnfgPropertyDetailsDTO(int cnfgId, String cnfgKey, String cnfgValue,
      String cnfgName) {
    super();
    this.cnfgId = cnfgId;
    this.cnfgKey = cnfgKey;
    this.cnfgValue = cnfgValue;
    this.cnfgName = cnfgName;
  }

  public CnfgPropertyDetailsDTO() {
    super();
  }

}
