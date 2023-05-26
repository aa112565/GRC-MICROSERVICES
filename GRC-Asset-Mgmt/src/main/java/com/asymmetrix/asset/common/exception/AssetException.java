package com.asymmetrix.asset.common.exception;

public class AssetException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AssetException(String errorMessage) {
		super(errorMessage);
	}

	public AssetException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
