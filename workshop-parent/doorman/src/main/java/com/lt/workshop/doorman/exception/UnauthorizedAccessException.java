package com.lt.workshop.doorman.exception;

public class UnauthorizedAccessException extends RuntimeException {

  public UnauthorizedAccessException(String message) {
    super(message);
  }

  public UnauthorizedAccessException(String message, Throwable e) {
    super(message, e);
  }
}