package com.lt.workshop.doorman.service.impl;

import com.lt.workshop.doorman.auth.domain.User;
import com.lt.workshop.doorman.auth.domain.UserRepository;
import com.lt.workshop.doorman.exception.TokenException;
import com.lt.workshop.doorman.exception.UnauthorizedAccessException;
import com.lt.workshop.doorman.service.AuthenticationService;
import com.lt.workshop.doorman.service.TokenStore;

public class AuthenticationServiceImpl implements AuthenticationService {

  private final TokenStore tokenStore;
  private final UserRepository userRepository;

  public AuthenticationServiceImpl(
      TokenStore tokenStore
      ,UserRepository userRepository
      ) {
    this.tokenStore = tokenStore;
    this.userRepository = userRepository;
  }

  @Override
  public String authenticate(String username, String password) {
    User user = userRepository.findByUsernameAndPassword(username, password);

    if (user == null) {
      throw new UnauthorizedAccessException("No user matches username " + username + " and password");
    }

    return tokenStore.generate(username);
  }

  @Override
  public String validate(String token) {
    try {
      return tokenStore.parse(token);
    } catch (TokenException e) {
      throw new UnauthorizedAccessException("No user matches such a token " + token, e);
    }
  }
}
