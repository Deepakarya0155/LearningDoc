package com.example.demo.controllers;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	
	@GetMapping("test")
	public String test() {
		return "working fine";
	}
	
	@GetMapping("token")
	public Jwt getTokenDetails(@AuthenticationPrincipal Jwt jwt) {
		return jwt;
	}
	
	
	@PreAuthorize("hasRole('developer1') or #id==#jwt.getSubject()")
	@GetMapping("del/{id}")
	public String delete(@PathVariable String id,@AuthenticationPrincipal Jwt jwt) {
		return "You passed "+id+" and jwt id "+jwt.getSubject();
	}
	
	@PostAuthorize("#jwt.getSubject()==returnObject.getSubject()")
	@GetMapping("get/{id}")
	public Jwt delete1(@AuthenticationPrincipal Jwt jwt) {
		System.out.println("method called");
		return jwt;
	}
	
}
