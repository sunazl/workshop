package com.lt.workshop.doorman.endpoint;

public class Token {
  private String token;

  public Token() {
  }

  public Token(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  @Override
  public String toString() {
    return "Token{" +
        "token='" + token + '\'' +
        '}';
  }
}