package core;

import java.util.Arrays;
import java.util.List;


class A{
	public static void f2() {
		System.out.println("A static");
	}
	public void f1() {
		System.out.println("A");
	}
}
class B extends A{
	public static void f2() {
		System.out.println("B static");
	}
	public void f1() {
		System.out.println("B");
	}
}


public class Test1 {
	public static void main(String[] args) {
		 A ab=new B();
		 ab.f1();
		 ab.f2();
	}
}
