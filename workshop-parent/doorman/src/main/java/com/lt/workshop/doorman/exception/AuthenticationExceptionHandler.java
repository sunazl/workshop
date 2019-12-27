package com.lt.workshop.doorman.exception;


import static org.springframework.http.HttpStatus.FORBIDDEN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * {@link AuthenticationExceptionHandler} intercepts response with {@link
 * UnauthorizedAccessException} and wraps the exception message in a forbidden response.
 */
@ControllerAdvice
public class AuthenticationExceptionHandler extends ResponseEntityExceptionHandler {

  private static final Logger logger = LoggerFactory.getLogger(AuthenticationExceptionHandler.class);

  @ExceptionHandler(UnauthorizedAccessException.class)
  ResponseEntity<String> handleException(UnauthorizedAccessException e) {
    logger.warn("Authentication failure", e);
    return new ResponseEntity<>(e.getMessage(), FORBIDDEN);
  }
}
