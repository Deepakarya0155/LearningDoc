


class A{
	String name="Deepak";
	public void f1() {
		System.out.println(name);
	}
}
class B extends A{
	String name="Arya";
	public void f1() {
		System.out.println(name);
	}
}

public class DynamicPolyformism {
	public static void main(String[] args) {
		A obj=new B();
		obj.f1();   // Arya
		System.out.println(obj.name);  // Deepak
	}
}
