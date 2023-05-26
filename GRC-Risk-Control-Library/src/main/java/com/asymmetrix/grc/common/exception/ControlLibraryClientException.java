package com.asymmetrix.grc.common.exception;

public class ControlLibraryClientException extends ControlLibraryException {

	private static final long serialVersionUID = 1L;

	public ControlLibraryClientException(String errorMessage) {
		super(errorMessage);
	}

	public ControlLibraryClientException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
