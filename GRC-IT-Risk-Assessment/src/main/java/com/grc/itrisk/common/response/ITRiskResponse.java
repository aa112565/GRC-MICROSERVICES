package com.grc.itrisk.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.grc.itrisk.common.constants.ITRiskConstants;

@JsonInclude(Include.NON_NULL)
public class ITRiskResponse<T> {

	private String errorMsg;
	private String status;
	private T result;

	public ITRiskResponse() {

	}

	public ITRiskResponse(T result) {
		super();
		this.status = ITRiskConstants.SUCCESS;
		this.result = result;
	}

	public ITRiskResponse(String status, String errorMsg) {
		super();
		this.status = status;
		this.errorMsg = errorMsg;
	}

	public ITRiskResponse(T result, String status, String errorMsg) {
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
