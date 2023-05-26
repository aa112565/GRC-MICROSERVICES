package com.asymmetrix.asset.common.exception;

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

import com.asymmetrix.asset.common.aspect.Loggable;
import com.asymmetrix.asset.common.constants.AssetErrorConstants;
import com.asymmetrix.asset.common.response.AssetResponse;
import com.asymmetrix.asset.common.response.AssetResponseEntity;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class AssetExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOG = LoggerFactory.getLogger(AssetExceptionHandler.class);

	private static final String ACCESS_DENIED = "ACCESS_DENIED";
	private static final String AUTHORIZATION_NOT_FOUND = "Authorization header is not found in request";
	@SuppressWarnings("unused")
	private static final String EXTERNAL_REST_CLIENT = "EXTERNAL_REST_CLIENT";

	@Loggable(action = ACCESS_DENIED)
	@ExceptionHandler(AccessDeniedException.class)
	protected ResponseEntity<AssetResponse<?>> handleAccessDeniedException(AccessDeniedException ex) {
		LOG.error(AssetErrorConstants.LOG_FAILED_DUE_TO, ex);
		return AssetResponseEntity.failure(
				new AssetResponse<String>(AssetErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	protected ResponseEntity<AssetResponse<?>> handleIllegalArgumentException(IllegalArgumentException ex) {
		LOG.error(AssetErrorConstants.LOG_FAILED_DUE_TO, ex);
		return AssetResponseEntity.failure(
				new AssetResponse<String>(AssetErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
	protected ResponseEntity<AssetResponse<?>> handleAuthException(AuthenticationCredentialsNotFoundException ex) {
		LOG.error(AssetErrorConstants.LOG_FAILED_DUE_TO, ex);
		return AssetResponseEntity.failure(
				new AssetResponse<String>(AssetErrorConstants.FAILED, AUTHORIZATION_NOT_FOUND), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(AssetRestClientException.class)
	protected ResponseEntity<AssetResponse<?>> handleRestClientException(Exception ex) {
		LOG.error(AssetErrorConstants.LOG_REST_CLIENT_ERROR, ex);
		return AssetResponseEntity.failure(
				new AssetResponse<String>(AssetErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AssetException.class)
	protected ResponseEntity<AssetResponse<?>> handleException(AssetException ex) {
		LOG.error(AssetErrorConstants.LOG_FAILED_DUE_TO, ex);
		return AssetResponseEntity.failure(
				new AssetResponse<String>(AssetErrorConstants.FAILED, ex.getLocalizedMessage()),
				HttpStatus.PRECONDITION_FAILED);
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<AssetResponse<?>> handleException(Exception ex) {
		LOG.error(AssetErrorConstants.LOG_ERROR, ex);
		return AssetResponseEntity.failure(
				new AssetResponse<String>(AssetErrorConstants.ERROR, ex.getLocalizedMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
