package com.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

class RequestDO{
	
	int id;
	String name;
	int age;
	List<String> hobbies=new ArrayList<>();
	
	public RequestDO(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "RequestDO [id=" + id + ", name=" + name + ", age=" + age + ", hobbies=" + hobbies + "]";
	}
	
	

	
}

public class ExampleHowToReadFields {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		
		RequestDO requestDO=new RequestDO(1, "Deepak", 26);
		
		requestDO.hobbies.add("music");
		
		
		System.out.println(requestDO);
		
		Class request=RequestDO.class;
		for(Field fields:request.getDeclaredFields()) {
			System.out.println(String.format("Field Name :: %s and Data Type :: %s ", 
					fields.getName(),fields.getType().getSimpleName()));
			
			System.out.println(String.format("Field value :: %s", fields.get(requestDO)));
			System.out.println(String.format("sintactic fields :: %s", fields.isSynthetic()));
			System.out.println("\n");
		}
		
		Field nameField=request.getDeclaredField("name");
		nameField.set(requestDO, "Deepak Arya");
		
		System.out.println(requestDO);
	}
	

}
