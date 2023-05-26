package com.grc.threat.common.exception;

public class ThreatLibraryClientException extends ThreatLibraryException {

	private static final long serialVersionUID = 1L;

	public ThreatLibraryClientException(String errorMessage) {
		super(errorMessage);
	}

	public ThreatLibraryClientException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
