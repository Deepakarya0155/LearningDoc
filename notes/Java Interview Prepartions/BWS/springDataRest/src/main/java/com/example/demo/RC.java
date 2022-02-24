package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@RequestMapping("")
public class RC {

	@GetMapping("test")
	@ResponseBody
	public String f1() {
		return "Hello world";
	}
}
