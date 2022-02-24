package com.example.demo;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DB {

	@Autowired
	EntityManager em;
	
	public void save(Object obj) {
		em.persist(obj);
	}
}
