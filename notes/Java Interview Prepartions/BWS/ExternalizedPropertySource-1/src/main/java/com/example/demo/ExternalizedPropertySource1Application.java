package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExternalizedPropertySource1Application implements CommandLineRunner{

	
	@Autowired
	ExtenalProp prop;
	
	public static void main(String[] args) {
		SpringApplication.run(ExternalizedPropertySource1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(prop.name);
	}

}
