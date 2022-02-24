package core;



public class test2 {
	
	public static void f1(String a1) {
		System.out.println("String");
	}
	public static void f1(Object a1) {
		System.out.println("Object");
	}
	

	public static void main(String[] args) {
		f1(null);
	}
	
}
