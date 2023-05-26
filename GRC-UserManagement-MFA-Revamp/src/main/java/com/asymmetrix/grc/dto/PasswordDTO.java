package com.asymmetrix.grc.dto;

public class PasswordDTO {

  private String token;
  private String newEncryptedPassword;
  private String oldEncryptedPassword;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getNewEncryptedPassword() {
    return newEncryptedPassword;
  }

  public void setNewEncryptedPassword(String newEncryptedPassword) {
    this.newEncryptedPassword = newEncryptedPassword;
  }

  public String getOldEncryptedPassword() {
    return oldEncryptedPassword;
  }

  public void setOldEncryptedPassword(String oldEncryptedPassword) {
    this.oldEncryptedPassword = oldEncryptedPassword;
  }

  public PasswordDTO() {
    super();
  }

  public PasswordDTO(String token, String newEncryptedPassword) {
    super();
    this.token = token;
    this.newEncryptedPassword = newEncryptedPassword;
  }

  public PasswordDTO(String token, String newEncryptedPassword, String oldEncryptedPassword) {
    super();
    this.newEncryptedPassword = newEncryptedPassword;
    this.oldEncryptedPassword = oldEncryptedPassword;
  }

}
