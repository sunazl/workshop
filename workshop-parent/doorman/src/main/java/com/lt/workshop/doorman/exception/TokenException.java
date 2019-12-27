package com.lt.workshop.doorman.exception;

public class TokenException extends RuntimeException {

  public TokenException(Throwable throwable) {
    super(throwable);
  }

  public TokenException() {

  }
}