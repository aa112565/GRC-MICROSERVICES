package com.grc.itrisk.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.grc.itrisk.common.aspect.Loggable;
import com.grc.itrisk.common.constants.ITRiskErrorConstants;
import com.grc.itrisk.common.response.ITRiskResponse;
import com.grc.itrisk.common.response.ITRiskResponseEntity;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ITRiskExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(ITRiskExceptionHandler.class);

	private static final String ACCESS_DENIED = "ACCESS_DENIED";
	private static final String AUTHORIZATION_NOT_FOUND = "Authorization header is not found in request";
	@SuppressWarnings("unused")
	private static final String EXTERNAL_REST_CLIENT = "EXTERNAL_REST_CLIENT";

	@Loggable(action = ACCESS_DENIED)
	@ExceptionHandler(AccessDeniedException.class)
	protected ResponseEntity<ITRiskResponse<?>> handleAccessDeniedException(AccessDeniedException ex) {
		LOG.error(ITRiskErrorConstants.LOG_FAILED_DUE_TO, ex);
		return ITRiskResponseEntity.failure(
				new ITRiskResponse<String>(ITRiskErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<ITRiskResponse<?>> handleIllegalArgumentException(IllegalArgumentException ex) {
		LOG.error(ITRiskErrorConstants.LOG_FAILED_DUE_TO, ex);
		return ITRiskResponseEntity.failure(
				new ITRiskResponse<String>(ITRiskErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
	protected ResponseEntity<ITRiskResponse<?>> handleAuthException(AuthenticationCredentialsNotFoundException ex) {
		LOG.error(ITRiskErrorConstants.LOG_FAILED_DUE_TO, ex);
		return ITRiskResponseEntity.failure(
				new ITRiskResponse<String>(ITRiskErrorConstants.FAILED, AUTHORIZATION_NOT_FOUND), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ITRiskRestClientException.class)
	protected ResponseEntity<ITRiskResponse<?>> handleRestClientException(Exception ex) {
		LOG.error(ITRiskErrorConstants.LOG_REST_CLIENT_ERROR, ex);
		return ITRiskResponseEntity.failure(
				new ITRiskResponse<String>(ITRiskErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ITRiskException.class)
	protected ResponseEntity<ITRiskResponse<?>> handleException(ITRiskException ex) {
		LOG.error(ITRiskErrorConstants.LOG_FAILED_DUE_TO, ex);
		return ITRiskResponseEntity.failure(
				new ITRiskResponse<String>(ITRiskErrorConstants.FAILED, ex.getLocalizedMessage()),
				HttpStatus.PRECONDITION_FAILED);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ITRiskResponse<?>> handleException(Exception ex) {
		LOG.error(ITRiskErrorConstants.LOG_ERROR, ex);
		return ITRiskResponseEntity.failure(
				new ITRiskResponse<String>(ITRiskErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
