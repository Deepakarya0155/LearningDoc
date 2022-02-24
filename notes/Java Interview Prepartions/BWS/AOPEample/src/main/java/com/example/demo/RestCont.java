package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.Business;
import com.example.demo.business.Business2;

@RestController
public class RestCont {

	@Autowired
	Business2 b2;
	
	@Autowired
	Business b1;
	
	@GetMapping("test")
	public void Test() {
		b1.f2("deepak");
//		b2.f1();
	}
}
