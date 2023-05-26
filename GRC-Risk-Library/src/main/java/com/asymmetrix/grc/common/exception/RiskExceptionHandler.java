package com.asymmetrix.grc.common.exception;

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

import com.asymmetrix.grc.common.aspect.Loggable;
import com.asymmetrix.grc.common.constants.RiskErrorConstants;
import com.asymmetrix.grc.common.response.RiskResponse;
import com.asymmetrix.grc.common.response.RiskResponseEntity;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RiskExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(RiskExceptionHandler.class);

	private static final String ACCESS_DENIED = "ACCESS_DENIED";
	private static final String AUTHORIZATION_NOT_FOUND = "Authorization header is not found in request";
	@SuppressWarnings("unused")
	private static final String EXTERNAL_REST_CLIENT = "EXTERNAL_REST_CLIENT";

	@Loggable(action = ACCESS_DENIED)
	@ExceptionHandler(AccessDeniedException.class)
	protected ResponseEntity<RiskResponse<?>> handleAccessDeniedException(AccessDeniedException ex) {
		LOG.error(RiskErrorConstants.LOG_FAILED_DUE_TO, ex);
		return RiskResponseEntity.failure(new RiskResponse<String>(RiskErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<RiskResponse<?>> handleIllegalArgumentException(IllegalArgumentException ex) {
		LOG.error(RiskErrorConstants.LOG_FAILED_DUE_TO, ex);
		return RiskResponseEntity.failure(new RiskResponse<String>(RiskErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
	protected ResponseEntity<RiskResponse<?>> handleAuthException(AuthenticationCredentialsNotFoundException ex) {
		LOG.error(RiskErrorConstants.LOG_FAILED_DUE_TO, ex);
		return RiskResponseEntity.failure(new RiskResponse<String>(RiskErrorConstants.FAILED, AUTHORIZATION_NOT_FOUND),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RiskRestClientException.class)
	protected ResponseEntity<RiskResponse<?>> handleRestClientException(Exception ex) {
		LOG.error(RiskErrorConstants.LOG_REST_CLIENT_ERROR, ex);
		return RiskResponseEntity.failure(new RiskResponse<String>(RiskErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RiskException.class)
	protected ResponseEntity<RiskResponse<?>> handleException(RiskException ex) {
		LOG.error(RiskErrorConstants.LOG_FAILED_DUE_TO, ex);
		return RiskResponseEntity.failure(new RiskResponse<String>(RiskErrorConstants.FAILED, ex.getLocalizedMessage()),
				HttpStatus.PRECONDITION_FAILED);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<RiskResponse<?>> handleException(Exception ex) {
		LOG.error(RiskErrorConstants.LOG_ERROR, ex);
		return RiskResponseEntity.failure(new RiskResponse<String>(RiskErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
