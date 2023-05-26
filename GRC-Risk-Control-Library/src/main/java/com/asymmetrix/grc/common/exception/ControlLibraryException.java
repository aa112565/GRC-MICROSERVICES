package com.asymmetrix.grc.common.exception;

public class ControlLibraryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ControlLibraryException(String errorMessage) {
		super(errorMessage);
	}

	public ControlLibraryException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
