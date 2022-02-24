package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	Long id;
	
	@OneToOne
	@MapsId
	Address ad;
	
}
