package com.asymmetrix.grc.entity.id;

import java.io.Serializable;

public class UserPreferencesId implements Serializable {

  private static final long serialVersionUID = 1L;

  private String userId;

  private String page;

  public UserPreferencesId() {}

  public UserPreferencesId(String userId, String page) {
    super();
    this.userId = userId;
    this.page = page;
  }

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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((page == null) ? 0 : page.hashCode());
    result = prime * result + ((userId == null) ? 0 : userId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof UserPreferencesId))
      return false;
    UserPreferencesId other = (UserPreferencesId) obj;
    if (page == null) {
      if (other.page != null)
        return false;
    } else if (!page.equals(other.page))
      return false;
    if (userId == null) {
      if (other.userId != null)
        return false;
    } else if (!userId.equals(other.userId))
      return false;
    return true;
  }



}
