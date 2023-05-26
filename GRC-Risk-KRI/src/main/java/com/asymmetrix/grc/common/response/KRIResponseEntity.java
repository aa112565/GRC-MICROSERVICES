package com.asymmetrix.grc.common.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class KRIResponseEntity {

	private KRIResponseEntity() {
	}

	public static <T> ResponseEntity<KRIResponse<?>> created(T t) {
		return ResponseEntity.status(HttpStatus.CREATED).body(new KRIResponse<T>(t));
	}

	public static <T> ResponseEntity<KRIResponse<T>> success(T t) {
		return ResponseEntity.status(HttpStatus.OK).body(new KRIResponse<T>(t));
	}

	public static <T> ResponseEntity<KRIResponse<?>> badRequest(T t) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new KRIResponse<T>(t));
	}

	public static <T> ResponseEntity<KRIResponse<?>> error(KRIResponse<?> t) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(t);
	}

	public static <T> ResponseEntity<KRIResponse<?>> failure(KRIResponse<?> t, HttpStatus status) {
		return ResponseEntity.status(status).body(t);
	}

	public static <T> ResponseEntity<KRIResponse<?>> success(String t) {
		return ResponseEntity.status(HttpStatus.OK).body(new KRIResponse<String>(t));
	}

}
