package com.lt.workshop.doorman.service.impl;

import static io.jsonwebtoken.SignatureAlgorithm.HS512;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import java.time.ZonedDateTime;
import java.util.Date;

import com.lt.workshop.doorman.exception.TokenException;
import com.lt.workshop.doorman.service.TokenStore;

/**
 * {@link JwtTokenStore} implements {@link TokenStore} with JWT token specifications.
 */
public class JwtTokenStore implements TokenStore {

  private final String secretKey;
  private final int secondsToExpire;

  /**
   * Constructor
   * @param secretKey the signing key to encrypt the token.
   * @param secondsToExpire the expire time in seconds.
   */
  public JwtTokenStore(String secretKey, int secondsToExpire) {
    this.secretKey = secretKey;
    this.secondsToExpire = secondsToExpire;
  }

  @Override
  public String generate(String username) {
    return Jwts.builder()
        .setSubject(username)
        .setExpiration(Date.from(ZonedDateTime.now().plusSeconds(secondsToExpire).toInstant()))
        .signWith(HS512, secretKey)
        .compact();
  }

  @Override
  public String parse(String token) {
    try {
      return Jwts.parser()
          .setSigningKey(secretKey)
          .parseClaimsJws(token)
          .getBody()
          .getSubject();
    } catch (JwtException | IllegalArgumentException e) {
      throw new TokenException(e);
    }
  }
}