package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MainProcess{
	Integer MainProcessid;
	String MainProcessName;
	public MainProcess(Integer mainProcessid, String mainProcessName) {
		super();
		MainProcessid = mainProcessid;
		MainProcessName = mainProcessName;
	}
	public MainProcess(String mainProcessid, String mainProcessName) {
		super();
		MainProcessid = Integer.parseInt(mainProcessid);
		MainProcessName = mainProcessName;
	}
	
	@Override
	public String toString() {
		return "MainProcess [MainProcessid=" + MainProcessid + ", MainProcessName=" + MainProcessName + "]";
	}
}
class OptionalProcess1{
	Integer OptionalProcess1id;
	String OptionalProcess1Name;
	public OptionalProcess1(Integer optionalProcess1id, String optionalProcess1Name) {
		super();
		OptionalProcess1id = optionalProcess1id;
		OptionalProcess1Name = optionalProcess1Name;
	}
	@Override
	public String toString() {
		return "OptionalProcess1 [OptionalProcess1id=" + OptionalProcess1id + ", OptionalProcess1Name="
				+ OptionalProcess1Name + "]";
	}
}
class OptionalProcess2{
	Integer OptionalProcess1id;
	String OptionalProcess1Name;
	public OptionalProcess2(Integer optionalProcess1id, String optionalProcess1Name) {
		super();
		OptionalProcess1id = optionalProcess1id;
		OptionalProcess1Name = optionalProcess1Name;
	}
	@Override
	public String toString() {
		return "OptionalProcess2 [OptionalProcess1id=" + OptionalProcess1id + ", OptionalProcess1Name="
				+ OptionalProcess1Name + "]";
	}
	
	
}


public class ConstructorAndInstaceExample {

	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		Integer trxid=1;
		List<String> ls=Arrays.asList("com.test.MainProcess","com.test.OptionalProcess1","com.test.OptionalProcess2");		

		MainProcess mainprocess=getInstace(MainProcess.class, "2","main");
		OptionalProcess1 optpro1=getInstace(OptionalProcess1.class, 1,"main");
		OptionalProcess2 optpro2=getInstace(OptionalProcess2.class, 2,"main");
		
		System.out.println(mainprocess);
		System.out.println(optpro1);
		System.out.println(optpro2);
		
	}
	
	public static <T> T getInstace(Class<T> className,Object ...objects ) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		T obj=null;
		for(Constructor<T> constr:(Constructor<T>[])className.getDeclaredConstructors()) {
			if(objects.length==constr.getParameterCount()) {
				if(getclassType(constr.getParameterTypes()).equals(getclassType(objects))) {
					
						obj=(T)constr.newInstance(objects);
					
				}
			}
		}
		if(obj==null) {
			System.out.println("Unable to find consturt for same");
		}
		
		return obj;
	}
	
	public static List<String> getclassType(Object ...objects ){
		return Stream.of(objects).map(Object::getClass).map(Class::getSimpleName).toList();
	}
	public static List<String> getclassType(Class<?>... objects){
		return Stream.of(objects).map(Class::getSimpleName).toList();
	}
}
