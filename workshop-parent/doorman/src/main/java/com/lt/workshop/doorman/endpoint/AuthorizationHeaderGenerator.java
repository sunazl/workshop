package com.lt.workshop.doorman.endpoint;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
class AuthorizationHeaderGenerator {

  static final String TOKEN_PREFIX = "Bearer ";

  HttpHeaders generate(String token) {
    HttpHeaders headers = new HttpHeaders();
    headers.add(AUTHORIZATION, TOKEN_PREFIX + token);
    return headers;
  }
}
