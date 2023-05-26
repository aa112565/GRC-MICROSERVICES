package com.asymmetrix.grc.common.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GRCResponseEntity {

  private GRCResponseEntity() {}

  public static <T> ResponseEntity<GRCResponse<?>> created(T t) {
    return ResponseEntity.status(HttpStatus.CREATED).body(new GRCResponse<T>(t));
  }

  public static <T> ResponseEntity<GRCResponse<?>> success(T t) {
    return ResponseEntity.status(HttpStatus.OK).body(new GRCResponse<T>(t));
  }

  public static <T> ResponseEntity<GRCResponse<?>> badRequest(T t) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GRCResponse<T>(t));
  }

  public static <T> ResponseEntity<GRCResponse<?>> error(GRCResponse<?> t) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(t);
  }

  public static <T> ResponseEntity<GRCResponse<?>> failure(GRCResponse<?> t, HttpStatus status) {
    return ResponseEntity.status(status).body(t);
  }

}
