package com.asymmetrix.grc.common.exception;

public class RiskRestClientException extends RiskException {

	private static final long serialVersionUID = 1L;

	public RiskRestClientException(String errorMessage) {
		super(errorMessage);
	}

	public RiskRestClientException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
