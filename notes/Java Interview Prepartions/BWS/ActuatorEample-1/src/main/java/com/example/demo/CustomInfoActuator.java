package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomInfoActuator implements InfoContributor{

	@Override
	public void contribute(Builder builder) {
		Map<String,Object> mp=new HashMap<>();
		mp.put("dd", "Dddd");
		builder.withDetails(mp);
	}

		
}
