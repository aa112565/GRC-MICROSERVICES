package com.grc.email.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grc.email.common.constants.GRCConstants;

@JsonInclude(Include.NON_NULL)
public class GRCResponse<T> {

  private String errorMsg;
  private String status;
  private T result;

  public GRCResponse(T result) {
    super();
    this.status = GRCConstants.SUCCESS;
    this.result = result;
  }

  public GRCResponse(String status, String errorMsg) {
    super();
    this.status = status;
    this.errorMsg = errorMsg;
  }

  public GRCResponse(T result, String status, String errorMsg) {
    super();
    this.status = status;
    this.result = result;
    this.errorMsg = errorMsg;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public void setErrorMsg(String errorMsg) {
    this.errorMsg = errorMsg;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public T getResult() {
    return result;
  }

  public void setResult(T result) {
    this.result = result;
  }

}
