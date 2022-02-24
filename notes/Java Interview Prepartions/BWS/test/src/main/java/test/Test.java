package test;


class A02{
	public static void f1() {
		System.out.println("Class A static method");
	}
	private void f2() {
		System.out.println("Class A Non- static method");
	}
	
}
class B01 extends A02{
	public static void f1() {
		System.out.println("Class B static method");
	}
	private void f2() {
		System.out.println("Class B Non - static method");
	}
}

public class Test {
	public static void main(String[] args) {
		A02 obj=new B01();

		obj.f1();
		obj.f2();
	}
}
