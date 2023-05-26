package com.asymmetrix.grc.common.exception;

public class KRIRestClientException extends KRIException {

	private static final long serialVersionUID = 1L;

	public KRIRestClientException(String errorMessage) {
		super(errorMessage);
	}

	public KRIRestClientException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
