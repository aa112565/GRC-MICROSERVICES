package com.grc.itrisk.common.exception;

public class ITRiskException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ITRiskException(String errorMessage) {
		super(errorMessage);
	}

	public ITRiskException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
