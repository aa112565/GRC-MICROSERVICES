package com.asymmetrix.grc.dto;

public class MailDetailsDTO {
  private String[] toAddress;
  private String subject;
  private String mailBodyContent;

  public MailDetailsDTO() {
    super();
  }

  public MailDetailsDTO(String[] toAddress, String subject, String mailBodyContent) {
    super();
    this.toAddress = toAddress;
    this.subject = subject;
    this.mailBodyContent = mailBodyContent;
  }

  public String[] getToAddress() {
    return toAddress;
  }

  public void setToAddress(String[] toAddress) {
    this.toAddress = toAddress;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getMailBodyContent() {
    return mailBodyContent;
  }

  public void setMailBodyContent(String mailBodyContent) {
    this.mailBodyContent = mailBodyContent;
  }

}
