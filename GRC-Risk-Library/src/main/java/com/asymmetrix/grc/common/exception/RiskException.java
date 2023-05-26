package com.asymmetrix.grc.common.exception;

public class RiskException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RiskException(String errorMessage) {
		super(errorMessage);
	}

	public RiskException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
