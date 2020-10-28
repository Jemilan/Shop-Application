package com.example.demo.exception;

import java.util.Objects;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class ExceptionHandle {

  @ExceptionHandler(value = ConstraintViolationException.class)
  public String handleDuplicateException(Exception exception) {
    Throwable throwable = getRootCause(exception);
    if (Objects.nonNull(throwable.getMessage())
        && throwable.getMessage().contains("Violation of UNIQUE KEY constraint")) {
      log.error(throwable.getMessage(), exception);
      return "Duplicate entry: " + throwable.getMessage();
    }
    return "Bad Request";
  }

  private Throwable getRootCause(Exception exception) {
    Throwable throwable = exception.getCause();
    while (throwable.getCause() != null) {
      throwable = throwable.getCause();
    }
    return throwable;
  }

  @ExceptionHandler(value = ValidationException.class)
  public String handleValidationException(Exception exception) {
    log.error(exception.getMessage(), exception);
    return exception.getMessage();
  }
}
