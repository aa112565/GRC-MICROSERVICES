package com.asymmetrix.grc.common.response;

import com.asymmetrix.grc.common.constants.ControlLibraryConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ControlLibraryResponse<T> {

	private String errorMsg;
	private String status;
	private T result;

	public ControlLibraryResponse() {

	}

	public ControlLibraryResponse(T result) {
		super();
		this.status = ControlLibraryConstants.SUCCESS;
		this.result = result;
	}

	public ControlLibraryResponse(String status, String errorMsg) {
		super();
		this.status = status;
		this.errorMsg = errorMsg;
	}

	public ControlLibraryResponse(T result, String status, String errorMsg) {
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
