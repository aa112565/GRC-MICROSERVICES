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
import com.asymmetrix.grc.common.constants.ControlLibraryErrorConstants;
import com.asymmetrix.grc.common.response.ControlLibraryResponse;
import com.asymmetrix.grc.common.response.ControlLibraryResponseEntity;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ControlLibraryExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(ControlLibraryExceptionHandler.class);

	private static final String ACCESS_DENIED = "ACCESS_DENIED";
	private static final String AUTHORIZATION_NOT_FOUND = "Authorization header is not found in request";
	@SuppressWarnings("unused")
	private static final String EXTERNAL_REST_CLIENT = "EXTERNAL_REST_CLIENT";

	@Loggable(action = ACCESS_DENIED)
	@ExceptionHandler(AccessDeniedException.class)
	protected ResponseEntity<ControlLibraryResponse<?>> handleAccessDeniedException(AccessDeniedException ex) {
		LOG.error(ControlLibraryErrorConstants.LOG_FAILED_DUE_TO, ex);
		return ControlLibraryResponseEntity.failure(
				new ControlLibraryResponse<String>(ControlLibraryErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<ControlLibraryResponse<?>> handleIllegalArgumentException(IllegalArgumentException ex) {
		LOG.error(ControlLibraryErrorConstants.LOG_FAILED_DUE_TO, ex);
		return ControlLibraryResponseEntity.failure(
				new ControlLibraryResponse<String>(ControlLibraryErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
	protected ResponseEntity<ControlLibraryResponse<?>> handleAuthException(
			AuthenticationCredentialsNotFoundException ex) {
		LOG.error(ControlLibraryErrorConstants.LOG_FAILED_DUE_TO, ex);
		return ControlLibraryResponseEntity.failure(
				new ControlLibraryResponse<String>(ControlLibraryErrorConstants.FAILED, AUTHORIZATION_NOT_FOUND),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ControlLibraryClientException.class)
	protected ResponseEntity<ControlLibraryResponse<?>> handleRestClientException(Exception ex) {
		LOG.error(ControlLibraryErrorConstants.LOG_REST_CLIENT_ERROR, ex);
		return ControlLibraryResponseEntity.failure(
				new ControlLibraryResponse<String>(ControlLibraryErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ControlLibraryException.class)
	protected ResponseEntity<ControlLibraryResponse<?>> handleException(ControlLibraryException ex) {
		LOG.error(ControlLibraryErrorConstants.LOG_FAILED_DUE_TO, ex);
		return ControlLibraryResponseEntity.failure(
				new ControlLibraryResponse<String>(ControlLibraryErrorConstants.FAILED, ex.getLocalizedMessage()),
				HttpStatus.PRECONDITION_FAILED);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ControlLibraryResponse<?>> handleException(Exception ex) {
		LOG.error(ControlLibraryErrorConstants.LOG_ERROR, ex);
		return ControlLibraryResponseEntity.failure(
				new ControlLibraryResponse<String>(ControlLibraryErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
