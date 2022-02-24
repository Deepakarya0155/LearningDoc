package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication
public class NonWebApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NonWebApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello world");
		
	}

}
