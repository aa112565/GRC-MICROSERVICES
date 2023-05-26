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
import com.asymmetrix.grc.common.constants.KRIErrorConstants;
import com.asymmetrix.grc.common.response.KRIResponse;
import com.asymmetrix.grc.common.response.KRIResponseEntity;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class KRIExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(KRIExceptionHandler.class);

	private static final String ACCESS_DENIED = "ACCESS_DENIED";
	private static final String AUTHORIZATION_NOT_FOUND = "Authorization header is not found in request";
	@SuppressWarnings("unused")
	private static final String EXTERNAL_REST_CLIENT = "EXTERNAL_REST_CLIENT";

	@Loggable(action = ACCESS_DENIED)
	@ExceptionHandler(AccessDeniedException.class)
	protected ResponseEntity<KRIResponse<?>> handleAccessDeniedException(AccessDeniedException ex) {
		LOG.error(KRIErrorConstants.LOG_FAILED_DUE_TO, ex);
		return KRIResponseEntity.failure(new KRIResponse<String>(KRIErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<KRIResponse<?>> handleIllegalArgumentException(IllegalArgumentException ex) {
		LOG.error(KRIErrorConstants.LOG_FAILED_DUE_TO, ex);
		return KRIResponseEntity.failure(new KRIResponse<String>(KRIErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
	protected ResponseEntity<KRIResponse<?>> handleAuthException(AuthenticationCredentialsNotFoundException ex) {
		LOG.error(KRIErrorConstants.LOG_FAILED_DUE_TO, ex);
		return KRIResponseEntity.failure(new KRIResponse<String>(KRIErrorConstants.FAILED, AUTHORIZATION_NOT_FOUND),
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(KRIRestClientException.class)
	protected ResponseEntity<KRIResponse<?>> handleRestClientException(Exception ex) {
		LOG.error(KRIErrorConstants.LOG_REST_CLIENT_ERROR, ex);
		return KRIResponseEntity.failure(new KRIResponse<String>(KRIErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(KRIException.class)
	protected ResponseEntity<KRIResponse<?>> handleException(KRIException ex) {
		LOG.error(KRIErrorConstants.LOG_FAILED_DUE_TO, ex);
		return KRIResponseEntity.failure(new KRIResponse<String>(KRIErrorConstants.FAILED, ex.getLocalizedMessage()),
				HttpStatus.PRECONDITION_FAILED);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<KRIResponse<?>> handleException(Exception ex) {
		LOG.error(KRIErrorConstants.LOG_ERROR, ex);
		return KRIResponseEntity.failure(new KRIResponse<String>(KRIErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
