package com.lt.workshop.doorman.auth;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lt.workshop.doorman.auth.domain.UserRepository;
import com.lt.workshop.doorman.service.AuthenticationService;
import com.lt.workshop.doorman.service.TokenStore;
import com.lt.workshop.doorman.service.impl.AuthenticationServiceImpl;
import com.lt.workshop.doorman.service.impl.JwtTokenStore;

@Configuration
class AuthenticationConfig {

  private static final int SECONDS_OF_A_DAY = 24 * 60 * 60;

  @Bean
  public AuthenticationService authenticationService(
      TokenStore tokenStore
      ,UserRepository repository
      ) {

    return new AuthenticationServiceImpl(tokenStore
    		, repository
    		);
  }

  @Bean
  public TokenStore tokenStore(@Value("${company.auth.secret:someSecretKey}") String secretKey) {
    return new JwtTokenStore(secretKey, SECONDS_OF_A_DAY);
  }
}