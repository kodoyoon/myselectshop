package com.sparta.myselectshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //모든 controller 에서 발생된 예외를 처리하기 위해서 global 적으로 사용이 된다.
public class GlobalExceptionHandler {

  @ExceptionHandler({IllegalArgumentException.class})
  public ResponseEntity<RestApiException> handleException(IllegalArgumentException ex) {
    RestApiException restApiException = new RestApiException(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    return new ResponseEntity<>(
        // HTTP body
        restApiException,
        // HTTP status code
        HttpStatus.BAD_REQUEST
    );
  }
}