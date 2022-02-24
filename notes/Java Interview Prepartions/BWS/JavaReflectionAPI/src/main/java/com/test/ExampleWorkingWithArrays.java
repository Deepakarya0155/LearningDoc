package com.test;

import java.lang.reflect.Array;

public class ExampleWorkingWithArrays {
	
	static Double[][] data= {{1d,2d},{3d,4d}};
	
	public static void main(String[] args) {
		Class<?> arraycls=data.getClass();
	
		if(arraycls.isArray()) {
			System.out.println( printArray(arraycls,data));
		}
	}
	
	
	public static String printArray(Class cls,Object obj) {
		
		int lenght=Array.getLength(obj);
		StringBuilder builder=new StringBuilder("[");
		
		for(int i=0;i<lenght;i++) {
			Object obj1=Array.get(obj, i);
			if(obj1.getClass().isArray()) {
				builder.append(printArray(obj1.getClass(), obj1));
			}else {
				builder.append(obj1);
			}
			if(i!=lenght-1) {
				builder.append(",");
			}
		}
		builder.append("]");
		return builder.toString();
	}

}
