package com.asymmetrix.grc.dto;

import java.util.Set;

public class UserPreferencesDTO {

  private String userId;
  private String page;
  private Set<String> columns;

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPage() {
    return page;
  }

  public void setPage(String page) {
    this.page = page;
  }

  public Set<String> getColumns() {
    return columns;
  }

  public void setColumns(Set<String> columns) {
    this.columns = columns;
  }

}
