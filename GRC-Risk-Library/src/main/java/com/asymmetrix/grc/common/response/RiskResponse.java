package com.asymmetrix.grc.common.response;

import com.asymmetrix.grc.common.constants.RiskConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class RiskResponse<T> {

	private String errorMsg;
	private String status;
	private T result;

	public RiskResponse() {

	}

	public RiskResponse(T result) {
		super();
		this.status = RiskConstants.SUCCESS;
		this.result = result;
	}

	public RiskResponse(String status, String errorMsg) {
		super();
		this.status = status;
		this.errorMsg = errorMsg;
	}

	public RiskResponse(T result, String status, String errorMsg) {
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
