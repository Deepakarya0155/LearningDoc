package com.paytm;

import java.util.TreeMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.paytm.pg.merchant.PaytmChecksum;

@SpringBootApplication
public class PaytmBackendApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PaytmBackendApplication.class, args);
	}

	@Override
	public void run(String...args) {
//		TreeMap<String,String> mp=new TreeMap<String,String>();
//		mp.put("MID","");
//		mp.put("ORDERID","")
//		
//		PaytmChecksum.generateSignature(mp, "");
	}
}
