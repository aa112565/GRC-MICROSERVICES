package com.asymmetrix.grc.common.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ControlLibraryResponseEntity {

	private ControlLibraryResponseEntity() {
	}

	public static <T> ResponseEntity<ControlLibraryResponse<?>> created(T t) {
		return ResponseEntity.status(HttpStatus.CREATED).body(new ControlLibraryResponse<T>(t));
	}

	public static <T> ResponseEntity<ControlLibraryResponse<T>> success(T t) {
		return ResponseEntity.status(HttpStatus.OK).body(new ControlLibraryResponse<T>(t));
	}

	public static <T> ResponseEntity<ControlLibraryResponse<?>> badRequest(T t) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ControlLibraryResponse<T>(t));
	}

	public static <T> ResponseEntity<ControlLibraryResponse<?>> error(ControlLibraryResponse<?> t) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(t);
	}

	public static <T> ResponseEntity<ControlLibraryResponse<?>> failure(ControlLibraryResponse<?> t,
			HttpStatus status) {
		return ResponseEntity.status(status).body(t);
	}

	public static <T> ResponseEntity<ControlLibraryResponse<?>> success(String t) {
		return ResponseEntity.status(HttpStatus.OK).body(new ControlLibraryResponse<String>(t));
	}

}
