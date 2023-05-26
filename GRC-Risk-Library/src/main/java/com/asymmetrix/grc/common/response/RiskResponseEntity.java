package com.asymmetrix.grc.common.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RiskResponseEntity {

	private RiskResponseEntity() {
	}

	public static <T> ResponseEntity<RiskResponse<?>> created(T t) {
		return ResponseEntity.status(HttpStatus.CREATED).body(new RiskResponse<T>(t));
	}

	public static <T> ResponseEntity<RiskResponse<T>> success(T t) {
		return ResponseEntity.status(HttpStatus.OK).body(new RiskResponse<T>(t));
	}

	public static <T> ResponseEntity<RiskResponse<?>> badRequest(T t) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RiskResponse<T>(t));
	}

	public static <T> ResponseEntity<RiskResponse<?>> error(RiskResponse<?> t) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(t);
	}

	public static <T> ResponseEntity<RiskResponse<?>> failure(RiskResponse<?> t, HttpStatus status) {
		return ResponseEntity.status(status).body(t);
	}

	public static <T> ResponseEntity<RiskResponse<?>> success(String t) {
		return ResponseEntity.status(HttpStatus.OK).body(new RiskResponse<String>(t));
	}

}
