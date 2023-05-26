package com.asymmetrix.asset.common.exception;

public class AssetRestClientException extends AssetException {

	private static final long serialVersionUID = 1L;

	public AssetRestClientException(String errorMessage) {
		super(errorMessage);
	}

	public AssetRestClientException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
