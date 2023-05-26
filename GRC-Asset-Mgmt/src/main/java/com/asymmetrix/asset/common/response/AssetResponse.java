package com.asymmetrix.asset.common.response;

import com.asymmetrix.asset.common.constants.AssetConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AssetResponse<T> {

	private String errorMsg;
	private String status;
	private T result;

	public AssetResponse() {

	}

	public AssetResponse(T result) {
		super();
		this.status = AssetConstants.SUCCESS;
		this.result = result;
	}

	public AssetResponse(String status, String errorMsg) {
		super();
		this.status = status;
		this.errorMsg = errorMsg;
	}

	public AssetResponse(T result, String status, String errorMsg) {
		super();
		this.status = status;
		this.result = result;
		this.errorMsg = errorMsg;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

}
