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

import com.asymmetrix.grc.common.response.GRCResponse;
import com.asymmetrix.grc.common.response.GRCResponseEntity;
import com.asymmetrix.grc.common.utils.constants.GRCErrorConstants;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GRCExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(GRCExceptionHandler.class);

	private static final String AUTHORIZATION_NOT_FOUND = "Authorization header is not found in request";

	@ExceptionHandler(AccessDeniedException.class)
	protected ResponseEntity<GRCResponse<?>> handleAccessDeniedException(AccessDeniedException ex) {
		LOG.error(GRCErrorConstants.LOG_FAILED_DUE_TO, ex);
		return GRCResponseEntity.failure(new GRCResponse<String>(GRCErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<GRCResponse<?>> handleIllegalArgumentException(IllegalArgumentException ex) {
		LOG.error(GRCErrorConstants.LOG_FAILED_DUE_TO, ex);
		return GRCResponseEntity.failure(new GRCResponse<String>(GRCErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
	protected ResponseEntity<GRCResponse<?>> handleAuthException(AuthenticationCredentialsNotFoundException ex) {
		LOG.error(GRCErrorConstants.LOG_FAILED_DUE_TO, ex);
		return GRCResponseEntity.failure(new GRCResponse<String>(GRCErrorConstants.FAILED, AUTHORIZATION_NOT_FOUND),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(GRCRestClientException.class)
	protected ResponseEntity<GRCResponse<?>> handleRestClientException(Exception ex) {
		LOG.error(GRCErrorConstants.LOG_REST_CLIENT_ERROR, ex);
		return GRCResponseEntity.failure(new GRCResponse<String>(GRCErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(GRCException.class)
	protected ResponseEntity<GRCResponse<?>> handleException(GRCException ex) {
		LOG.error(GRCErrorConstants.LOG_FAILED_DUE_TO, ex);
		return GRCResponseEntity.failure(new GRCResponse<String>(GRCErrorConstants.FAILED, ex.getLocalizedMessage()),
				HttpStatus.PRECONDITION_FAILED);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<GRCResponse<?>> handleException(Exception ex) {
		LOG.error(GRCErrorConstants.LOG_ERROR, ex);
		return GRCResponseEntity.failure(new GRCResponse<String>(GRCErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
