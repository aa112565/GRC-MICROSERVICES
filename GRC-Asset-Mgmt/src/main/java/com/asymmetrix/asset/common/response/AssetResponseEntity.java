package com.asymmetrix.asset.common.response;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

public class AssetResponseEntity {

	private AssetResponseEntity() {
	}

	public static <T> ResponseEntity<AssetResponse<?>> created(T t) {
		return ResponseEntity.status(HttpStatus.CREATED).body(new AssetResponse<T>(t));
	}

	public static <T> ResponseEntity<AssetResponse<T>> success(T t) {
		return ResponseEntity.status(HttpStatus.OK).body(new AssetResponse<T>(t));
	}

	public static <T> ResponseEntity<AssetResponse<?>> badRequest(T t) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AssetResponse<T>(t));
	}

	public static <T> ResponseEntity<AssetResponse<?>> error(AssetResponse<?> t) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(t);
	}

	public static <T> ResponseEntity<AssetResponse<?>> failure(AssetResponse<?> t, HttpStatus status) {
		return ResponseEntity.status(status).body(t);
	}

	public static <T> ResponseEntity<?> downloadResponse(byte[] supportDoc, String docType, String docName) {
		ByteArrayResource resource = new ByteArrayResource(supportDoc);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-disposition", "attachment; filename=" + docName);
		return ResponseEntity.ok().headers(headers).contentLength(resource.contentLength())
				.contentType(MediaType.parseMediaType(docType)).body(resource);
	}

}
