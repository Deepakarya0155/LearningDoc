package test;

import java.util.*;
import java.util.stream.Collectors;

class A1{
	public void m1(String obj) {
		System.out.println("String");
	}
}
class B1 extends A1{
	public void m1(Object o1) {
		System.out.println("Object");
	}
}

public class DequeuTest {
	public static void main(String[] args) {
		
		B1 ob=new B1();
		ob.m1(null);
		
	}
}
