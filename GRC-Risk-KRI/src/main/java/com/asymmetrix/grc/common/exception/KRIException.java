package com.asymmetrix.grc.common.exception;

public class KRIException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public KRIException(String errorMessage) {
		super(errorMessage);
	}

	public KRIException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
