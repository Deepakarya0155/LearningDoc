package overriding;

class Person{
}
class Employee extends Person{
}


class A{
	public static void f1() {
		System.out.println("Class A");
	}
	public Object f2() {
		System.out.println("Class A f2");
		return new Person();
	}
}
class B extends A{
	public static void f1() {
		System.out.println("Class B");
	}
	public String f2() {
		System.out.println("Class B f2");
		return "";
	}
}
public class OverridingExample {
	public static void main(String[] args) {
		A obj=new B();
		obj.f1();
		obj.f2();
		
		Collections.syn
	}
}
