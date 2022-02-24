package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Person {

	@Id
	Long id;
	
	@Lob
	byte[] img;
}
