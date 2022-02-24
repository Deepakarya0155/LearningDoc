package core;

import java.io.IOException;

class A1{
	public Object f1(String name) throws Exception{
		System.out.println("Object");
		return null;
	}
}
class B2 extends A1{
	public String f1(String name) throws IOException{
		System.out.println("String");
		return null;
	}
}
public class test5 {
	
	public static void main(String[] args) throws Exception {
		A1 ab=new B2();
		ab.f1("Deepak");
	}

}
