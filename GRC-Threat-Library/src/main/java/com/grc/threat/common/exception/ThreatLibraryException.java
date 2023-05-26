package com.grc.threat.common.exception;

public class ThreatLibraryException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ThreatLibraryException(String errorMessage) {
		super(errorMessage);
	}

	public ThreatLibraryException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
