package com.asymmetrix.grc.entity;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.asymmetrix.grc.entity.converter.UserPreferencesConverter;
import com.asymmetrix.grc.entity.id.UserPreferencesId;

@Entity
@Table(name = "CNFG_USER_PREFERNCES")
@IdClass(UserPreferencesId.class)
public class UserPreferences {

  @Id
  @Column(name = "V_USER_ID")
  private String userId;

  @Id
  @Column(name = "V_PAGE")
  private String page;

  @Convert(converter = UserPreferencesConverter.class)
  @Column(name = "V_COLUMN_PREFERNCES")
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
