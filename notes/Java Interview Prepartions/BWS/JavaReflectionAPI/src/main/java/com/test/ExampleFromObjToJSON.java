package com.test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

class Person{
	int age;
	String name;
	Address[] address;
	Job job;
	public Person(int age, String name, Address[] address, Job title) {
		super();
		this.age = age;
		this.name = name;
		this.address = address;
		this.job = title;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", address=" + address + ", title=" + job + "]";
	}
	
	
	
}
class Address{
	String type;
	String city;
	public Address(String type, String city) {
		super();
		this.type = type;
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "Address [type=" + type + ", city=" + city + "]";
	}

	
	
}
class Job{
	String title;

	public Job(String title) {
		super();
		this.title = title;
	}

	@Override
	public String toString() {
		return "Job [title=" + title + "]";
	}
	
}

public class ExampleFromObjToJSON {

	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		Job job=new Job("Sn Consultant");
		Address home=new Address("Home","Abohar");
		Address office=new Address("Office","Gurgaon");
		
		Person person=new Person(26,"Deepak",new Address[] {home,office},job);
//		ObjToJson(person);
		System.out.println(ObjToJson(person));
	}
	
	public static String ObjToJson(Object obj) throws IllegalArgumentException, IllegalAccessException {
		Class className=obj.getClass();
		
		StringBuilder builder=new StringBuilder("{\n");
		
		for(int i=0;i<className.getDeclaredFields().length;i++) {
			Field fields=className.getDeclaredFields()[i];
			
			if(fields.getType().isArray()) {
//				
				builder.append("\t\""+fields.getName()+"\":\n\t ["+ processArray(fields.get(obj))+" ]");
			}else {
			
				builder.append(fieldProcessor(fields,obj));
			}
			if(i!=className.getDeclaredFields().length-1) {
				builder.append(",\n");
			}
			
		}
		
		
		builder.append("}");
		return builder.toString();
	}
	
	
	public static String fieldProcessor(Field fields,Object obj) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder builder=new StringBuilder("");
		if(fields.getType().isPrimitive()) {
			builder.append("\t\""+fields.getName()+"\":"+fields.get(obj));
		}
		else if(fields.getType().equals(String.class)) {
			builder.append("\t\""+fields.getName()+"\":\""+fields.get(obj)+"\"");
			
		}
		else {
			builder.append("\t\""+fields.getName()+"\":"+ObjToJson(fields.get(obj)));
		}
		return builder.toString();
	}
	public static String fieldProcessor(Class fields,Object obj) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder builder=new StringBuilder("");
	
		if(fields.isPrimitive()) {
	
			builder.append(obj+",");
		}
		else if(fields.equals(String.class)) {
			
			builder.append(obj+",");
		}
		else {
			
			builder.append(ObjToJson(obj));
		}
		return builder.toString();
	}
	public static String processArray(Object obj) throws IllegalArgumentException, IllegalAccessException {
		StringBuilder builder=new StringBuilder("");
		int arrayLenght = Array.getLength(obj);
		for(int i=0;i<arrayLenght;i++) {
			Object o1=Array.get(obj, i);
			if(o1.getClass().isArray()) {
				
				builder.append( processArray(o1));
			}else {
				builder.append(fieldProcessor(obj.getClass(), o1)+",\n");
//				
				
			}
		}
		return builder.toString();
	}
	
	
	
	

}
