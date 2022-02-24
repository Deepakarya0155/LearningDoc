package com.test;

import java.util.HashMap;
import java.util.Map;

interface ServicInterface{
	
}
class Test implements ServicInterface{
	
}
enum Enum1{
	Deepak,Vicky,kaku
}

public class MainClass {
	
	public static void printClasses(Class<?> ... classes )
	{
		
		
		for(Class<?> class1:classes) {
			System.out.println(String.format("class = %s & package = %s",class1.getSimpleName(),class1.getPackageName()));
			for(Class<?> interfaceclass:class1.getInterfaces()) {
				System.out.println(String.format("class = %s & interface = %s",class1.getSimpleName()
						,interfaceclass.getSimpleName()));
			}
			
			System.out.println("Is enum = "+class1.isEnum());
			System.out.println("Is interface = "+class1.isInterface());
			System.out.println("Is array = "+class1.isArray());
			System.out.println("Is permitive ="+ class1.isPrimitive());
			System.out.println("\n\n");
		}
	
	}
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class<?> stringClass=String.class;
		
		Map<String,String> mp=new HashMap<>();
		Class<?> mpclass=mp.getClass();
		
		Class<?> testClass=Class.forName("com.test.Test");
		
		Class<?> enumClass=Enum1.class;
		
		
//		printClasses(stringClass,mpclass,testClass,enumClass);
		
		printClasses(ServicInterface.class,enumClass,int.class,int[].class);
	}
}
