package com.asymmetrix.grc.oauth.common.exception;

public class GRCException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public GRCException(String errorMessage) {
    super(errorMessage);
  }

  public GRCException(String errorMessage, Throwable err) {
    super(errorMessage, err);
  }

}
