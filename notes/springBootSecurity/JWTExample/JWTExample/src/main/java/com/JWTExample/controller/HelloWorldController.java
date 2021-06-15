package com.JWTExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JWTExample.JwtUtils;

@RestController
public class HelloWorldController {

	
	@Autowired
	UserDetailsService userdetailsservice;
	
	@Autowired
	AuthenticationManager authmanager;
	
	@Autowired
	JwtUtils jwtutils;
	
	@GetMapping("auth")
	public String auth(String username,String password) {
		authmanager.authenticate(new UsernamePasswordAuthenticationToken(username, username));
		
		return jwtutils.generateToken(userdetailsservice.loadUserByUsername(username));
	}
	
	@GetMapping("hello")
	public String hello() {
		return "Hello world";
	}
}
