package com.example.demo.business;

import org.springframework.stereotype.Component;

import com.example.demo.TrackTime;

@Component
public class Business {

	
	public void f1() {
		System.out.println("Hello world");
	}
	
	@TrackTime
	public void f2(String name) {
		System.out.println("Track2");
	}
}
