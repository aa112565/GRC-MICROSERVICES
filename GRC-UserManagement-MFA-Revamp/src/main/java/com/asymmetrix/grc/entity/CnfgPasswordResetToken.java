package com.asymmetrix.grc.entity;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "CNFG_PASSWORD_RESET_TOKEN")
public class CnfgPasswordResetToken {

  @Id
  @Column(name = "V_TOKEN")
  private String token;

  @OneToOne(targetEntity = CnfgUser.class, fetch = FetchType.EAGER)
  @JoinColumn(nullable = false, name = "V_USER_ID")
  private CnfgUser cnfgUser;

  @Column(name = "D_EXPIRY")
  private Date expiryDate;

  public CnfgPasswordResetToken() {
    super();
  }

  public CnfgPasswordResetToken(final String token, int expirationTime) {
    super();
    this.token = token;
    this.expiryDate = calculateExpiryDate(expirationTime);
  }

  public CnfgPasswordResetToken(final String token, CnfgUser cnfgUser, int expirationTime) {
    super();
    this.token = token;
    this.cnfgUser = cnfgUser;
    this.expiryDate = calculateExpiryDate(expirationTime);
  }

  public String getToken() {
    return token;
  }

  public void setToken(final String token) {
    this.token = token;
  }

  public Date getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(final Date expiryDate) {
    this.expiryDate = expiryDate;
  }

  private Date calculateExpiryDate(final int expiryTimeInMinutes) {
    final Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(new Date().getTime());
    cal.add(Calendar.MINUTE, expiryTimeInMinutes);
    return new Date(cal.getTime().getTime());
  }

  public CnfgUser getCnfgUser() {
    return cnfgUser;
  }

  public void setCnfgUser(CnfgUser cnfgUser) {
    this.cnfgUser = cnfgUser;
  }

  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder();
    builder.append("Token [String=").append(token).append("]").append("[Expires").append(expiryDate)
        .append("]");
    return builder.toString();
  }

}
