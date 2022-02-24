package com.dome;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Employee {

	@Id
	Long id;
	
	String fname;
	String lname;
	
}
