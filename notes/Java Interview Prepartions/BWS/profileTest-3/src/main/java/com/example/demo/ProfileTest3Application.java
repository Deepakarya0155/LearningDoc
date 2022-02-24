package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class ProfileTest3Application implements CommandLineRunner{

	@Value("${name}")
	String name;
	
	@Autowired
	Environment env;
	
	@Autowired
	Sort sort;
	
	public static void main(String[] args) {
		SpringApplication.run(ProfileTest3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(name);
		System.out.println(env.getProperty("spring.profiles.active"));
		sort.sort();
	}

}
