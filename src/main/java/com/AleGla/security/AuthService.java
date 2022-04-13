package com.AleGla.security;

public interface AuthService {

	Boolean validateBasicAuthentication(String username, String password, String basicAuthHeaderValue);
}
