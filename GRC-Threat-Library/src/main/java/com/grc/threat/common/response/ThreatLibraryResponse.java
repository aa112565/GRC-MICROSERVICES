package com.grc.threat.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grc.threat.common.constants.ThreatLibraryConstants;

@JsonInclude(Include.NON_NULL)
public class ThreatLibraryResponse<T> {

	private String errorMsg;
	private String status;
	private T result;

	public ThreatLibraryResponse() {

	}

	public ThreatLibraryResponse(T result) {
		super();
		this.status = ThreatLibraryConstants.SUCCESS;
		this.result = result;
	}

	public ThreatLibraryResponse(String status, String errorMsg) {
		super();
		this.status = status;
		this.errorMsg = errorMsg;
	}

	public ThreatLibraryResponse(T result, String status, String errorMsg) {
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
