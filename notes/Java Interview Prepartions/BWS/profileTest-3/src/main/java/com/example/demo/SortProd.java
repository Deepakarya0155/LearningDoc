package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("PROD")
@Component("sort")
public class SortProd implements Sort {

	@Override
	public void sort() {
		System.out.println("PROD");
	}

}
