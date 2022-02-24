package com.dome;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TestSch {
	
//	@Scheduled(fixedDelay = 1000)
//	@Scheduled(cron = "* * * * * *")
	public void f1() {
		System.out.println("hiii");
	}
}
