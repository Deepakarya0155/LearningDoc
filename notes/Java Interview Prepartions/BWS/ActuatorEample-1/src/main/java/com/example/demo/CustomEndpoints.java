package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;


//http://localhost:8080/actuator/appDetails
@Component
@Endpoint(id="appDetails")
public class CustomEndpoints {

	Map<String,String> mp=new HashMap<>();
	
	public CustomEndpoints() {
		mp.put("name","Deepak");
		mp.put("age","25");
	}
	
//	http://localhost:8080/actuator/appDetails     # GET
	@ReadOperation
	public Map getAllDetails() {
		return mp;
	}
	
//	http://localhost:8080/actuator/appDetails/name   # GET
	@ReadOperation
	public String getDetails(@Selector String key) {
		return mp.get(key);
	}
// http://localhost:8080/actuator/appDetails/name # DELETE
	@DeleteOperation								
	public void delete(@Selector String key) {
		mp.remove(key);
	}


//http://localhost:8080/actuator/appDetails/city   # POST  #Content/Type application/json
	@WriteOperation
	public void add(@Selector String key,String value) {
		mp.put(key,value);
	}
	
	
	
}
