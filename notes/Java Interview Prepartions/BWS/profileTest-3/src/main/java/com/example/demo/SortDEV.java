package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"DEV","QA"})
@Component("sort")
public class SortDEV implements Sort{

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		System.out.println("DEV & QA");
	}

}
