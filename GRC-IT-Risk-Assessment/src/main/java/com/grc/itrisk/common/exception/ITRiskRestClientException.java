package com.grc.itrisk.common.exception;

public class ITRiskRestClientException extends ITRiskException {

	private static final long serialVersionUID = 1L;

	public ITRiskRestClientException(String errorMessage) {
		super(errorMessage);
	}

	public ITRiskRestClientException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
