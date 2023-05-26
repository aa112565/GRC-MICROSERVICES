package com.grc.threat.common.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ThreatLibraryResponseEntity {

	private ThreatLibraryResponseEntity() {
	}

	public static <T> ResponseEntity<ThreatLibraryResponse<?>> created(T t) {
		return ResponseEntity.status(HttpStatus.CREATED).body(new ThreatLibraryResponse<T>(t));
	}

	public static <T> ResponseEntity<ThreatLibraryResponse<T>> success(T t) {
		return ResponseEntity.status(HttpStatus.OK).body(new ThreatLibraryResponse<T>(t));
	}

	public static <T> ResponseEntity<ThreatLibraryResponse<?>> badRequest(T t) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ThreatLibraryResponse<T>(t));
	}

	public static <T> ResponseEntity<ThreatLibraryResponse<?>> error(ThreatLibraryResponse<?> t) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(t);
	}

	public static <T> ResponseEntity<ThreatLibraryResponse<?>> failure(ThreatLibraryResponse<?> t,
			HttpStatus status) {
		return ResponseEntity.status(status).body(t);
	}

	public static <T> ResponseEntity<ThreatLibraryResponse<?>> success(String t) {
		return ResponseEntity.status(HttpStatus.OK).body(new ThreatLibraryResponse<String>(t));
	}

}
