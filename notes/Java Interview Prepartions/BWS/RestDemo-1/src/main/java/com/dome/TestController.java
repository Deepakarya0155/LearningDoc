package com.dome;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("testGet")
	public String test(@RequestParam(value = "name") String name) {
		return "Success GET "+name;
	}
//	@GetMapping("testGet/{name}/{lname}")
//	public String test2(@PathVariable("name") String name,@PathVariable("lname") String lname) {
//		return "Success GET "+name+" "+lname;
//	}
//	
//	@PostMapping("testGet")
//	public String testPost(@RequestBody Employee emp) {
//		String a="De";
//		a.length();
//		return "Success "+emp;
//	}

}
