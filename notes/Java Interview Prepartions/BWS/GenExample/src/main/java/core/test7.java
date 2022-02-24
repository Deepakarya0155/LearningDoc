package core;

import java.io.IOException;

class A2{
	public String f1(String name) throws IOException{
		System.out.println("Object");
		return null;
	}
}
class B3 extends A2{
	public Object f1(String name) throws Exception{
		System.out.println("String");
		return null;
	}
}
public class test7 {
	public static void main(String[] args) throws Exception {
		A1 ab=new B2();
		ab.f1("Deepak");
	}
}
