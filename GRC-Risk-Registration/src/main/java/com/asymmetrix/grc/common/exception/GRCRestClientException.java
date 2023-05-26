package com.asymmetrix.grc.common.exception;

public class GRCRestClientException extends GRCException {  

  private static final long serialVersionUID = 1L;

  public GRCRestClientException(String errorMessage) {
    super(errorMessage);
  }

  public GRCRestClientException(String errorMessage, Throwable err) {
    super(errorMessage, err);
  }

}
