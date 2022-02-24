package com.example.demo;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class RSController {

	@Autowired
	PersonRepo Personrepo;
	
	@PostMapping(path="upload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public List uploadFile(@RequestPart("files") List<MultipartFile> files ) throws IOException {
		
		Person p=new Person();
		byte[] bt=files.get(0).getBytes();
		p.setId(1l);
		p.setImg(bt);
		Personrepo.save(p);
		
		Person ppp=Personrepo.findById(1l).get();
		
		FileOutputStream out=new FileOutputStream("gyan.pdf");
		out.write(ppp.getImg());
		out.close();
		
		return Arrays.asList("success");
	}
	
	
	@Autowired
	EntityManager em;
	
	@GetMapping("ddd")
	@Transactional
	public void postMethod() {
	
		Address ad=new Address();
		ad.city="Abohar";
		ad.id=1l;
		
		em.persist(ad);
		Employee emp=new Employee();
		emp.setAd(ad);
		em.persist(emp);
	}
}
