package cloneExample;

class Emp implements Cloneable{
	
	String name;

	public Emp() {
		super();
		System.out.println("Default");
	}
	
	public Emp(String name) {
		this();
		
		this.name = name;
	}



	@Override
	public String toString() {
		return "Emp [name=" + name + "]";
	}



	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

public class Test {
	static {
		System.out.println("static");
	}
	{
		System.out.println("Default");
	}
	
	Test(){
		System.out.println("constructor");
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Test a=new Test();
		Test b=new Test();
	}
}
