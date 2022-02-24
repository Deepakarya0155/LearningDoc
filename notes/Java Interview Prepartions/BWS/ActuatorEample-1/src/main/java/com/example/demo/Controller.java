package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@GetMapping("test")
	public void f1() {
		System.out.println("jjj");
	}
}
