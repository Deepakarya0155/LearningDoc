package com.example.demo;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.business.EmployeeRepo;

@SpringBootApplication
public class SpringDataRestApplication implements CommandLineRunner{

	@Autowired
	EmployeeRepo repo;
	
	@Autowired
	Serv serv;

	@Autowired
	Repo rp;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		
	}

	@Override
	public void run(String... args) throws Exception {
		repo.saveAll(Arrays.asList(new Employee(1l,"deepak","arya","arya@gmail.com")
				
				,new Employee(2l,"deepak2","arya2","arya2@gmail.com")
				,new Employee(3l,"deepak3","arya3","arya3@gmail.com")
				,new Employee(4l,"deepak4","arya4","arya4@gmail.com")));
//		)
		
		serv.f1();
		rp.findAll().forEach(System.out::println);
	}

}
