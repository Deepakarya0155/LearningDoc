package com.example.demo.business;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;

import com.example.demo.Employee;

@Repository
@RepositoryRestResource(path ="employee")
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	
	public Employee findByFname(@Param("name") String name) ;
}
