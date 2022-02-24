package com.example.demo;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestD {

//	@Scheduled(fixedDelay = 2000)
	@Scheduled(cron = "59 * * * * *")
	public void f1() {
		System.out.println((new Date())+"ddd");
	}
}
