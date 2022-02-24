package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class PrivateConstructorClass{
	
	private PrivateConstructorClass(){
		System.out.println("Private constructor called");
	}
}

public class ExampleHowToAccessPrivateConstructor {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class privaclass=PrivateConstructorClass.class;
		PrivateConstructorClass obj=null;
		for(Constructor constru:privaclass.getDeclaredConstructors()) {
			constru.setAccessible(true);
			obj=(PrivateConstructorClass)constru.newInstance();
		}
		System.out.println(obj);
	}
}
