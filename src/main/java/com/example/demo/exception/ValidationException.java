package com.example.demo.exception;

public class ValidationException extends RuntimeException {

  private static final long serialVersionUID = -2695252789538915451L;

  public ValidationException(String message) {
    super(message);
  }

}
