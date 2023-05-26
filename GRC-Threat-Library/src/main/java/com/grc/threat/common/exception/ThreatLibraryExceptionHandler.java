package com.grc.threat.common.exception;

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

import com.grc.threat.common.aspect.Loggable;
import com.grc.threat.common.constants.ThreatLibraryErrorConstants;
import com.grc.threat.common.response.ThreatLibraryResponse;
import com.grc.threat.common.response.ThreatLibraryResponseEntity;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ThreatLibraryExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(ThreatLibraryExceptionHandler.class);

	private static final String ACCESS_DENIED = "ACCESS_DENIED";
	private static final String AUTHORIZATION_NOT_FOUND = "Authorization header is not found in request";
	@SuppressWarnings("unused")
	private static final String EXTERNAL_REST_CLIENT = "EXTERNAL_REST_CLIENT";

	@Loggable(action = ACCESS_DENIED)
	@ExceptionHandler(AccessDeniedException.class)
	protected ResponseEntity<ThreatLibraryResponse<?>> handleAccessDeniedException(AccessDeniedException ex) {
		LOG.error(ThreatLibraryErrorConstants.LOG_FAILED_DUE_TO, ex);
		return ThreatLibraryResponseEntity.failure(
				new ThreatLibraryResponse<String>(ThreatLibraryErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<ThreatLibraryResponse<?>> handleIllegalArgumentException(IllegalArgumentException ex) {
		LOG.error(ThreatLibraryErrorConstants.LOG_FAILED_DUE_TO, ex);
		return ThreatLibraryResponseEntity.failure(
				new ThreatLibraryResponse<String>(ThreatLibraryErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
	protected ResponseEntity<ThreatLibraryResponse<?>> handleAuthException(
			AuthenticationCredentialsNotFoundException ex) {
		LOG.error(ThreatLibraryErrorConstants.LOG_FAILED_DUE_TO, ex);
		return ThreatLibraryResponseEntity.failure(
				new ThreatLibraryResponse<String>(ThreatLibraryErrorConstants.FAILED, AUTHORIZATION_NOT_FOUND),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ThreatLibraryClientException.class)
	protected ResponseEntity<ThreatLibraryResponse<?>> handleRestClientException(Exception ex) {
		LOG.error(ThreatLibraryErrorConstants.LOG_REST_CLIENT_ERROR, ex);
		return ThreatLibraryResponseEntity.failure(
				new ThreatLibraryResponse<String>(ThreatLibraryErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ThreatLibraryException.class)
	protected ResponseEntity<ThreatLibraryResponse<?>> handleException(ThreatLibraryException ex) {
		LOG.error(ThreatLibraryErrorConstants.LOG_FAILED_DUE_TO, ex);
		return ThreatLibraryResponseEntity.failure(
				new ThreatLibraryResponse<String>(ThreatLibraryErrorConstants.FAILED, ex.getLocalizedMessage()),
				HttpStatus.PRECONDITION_FAILED);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ThreatLibraryResponse<?>> handleException(Exception ex) {
		LOG.error(ThreatLibraryErrorConstants.LOG_ERROR, ex);
		return ThreatLibraryResponseEntity.failure(
				new ThreatLibraryResponse<String>(ThreatLibraryErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
