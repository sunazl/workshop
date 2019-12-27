package com.lt.workshop.doorman.service;

public interface AuthenticationService {
	String authenticate(String username, String password);

	String validate(String token);
}
