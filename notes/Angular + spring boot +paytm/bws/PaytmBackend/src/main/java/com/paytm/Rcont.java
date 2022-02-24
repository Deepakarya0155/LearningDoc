package com.paytm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rcont {

	
//	@GetMapping("/emp/{id}")
//	public void getM(@PathVariable(name="id",required = false) String id) {
//		System.out.println(id);
//	}
	@PostMapping("/emp/{id}")
	public void getM1(@PathVariable(name="id") String id) {
		System.out.println(id);
	}
}
