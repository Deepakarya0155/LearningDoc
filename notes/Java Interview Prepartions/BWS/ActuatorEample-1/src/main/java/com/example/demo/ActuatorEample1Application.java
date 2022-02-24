package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ActuatorEample1Application implements CommandLineRunner {
	
	@Value("${info.application.name}")
	String cm;

	public static void main(String[] args) {
		SpringApplication.run(ActuatorEample1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(cm);
		
	}

}
