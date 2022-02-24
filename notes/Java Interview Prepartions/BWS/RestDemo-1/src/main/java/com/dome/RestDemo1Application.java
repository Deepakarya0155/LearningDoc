package com.dome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RestDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(RestDemo1Application.class, args);
	}

}
