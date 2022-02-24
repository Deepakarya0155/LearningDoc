package test;

public class IsLandOfIsolationExample {

	IsLandOfIsolationExample obj;
	
	public static void main(String[] args) {
		IsLandOfIsolationExample a1=new IsLandOfIsolationExample();
		IsLandOfIsolationExample a2=new IsLandOfIsolationExample();
		
		a1.obj=a2;
		a2.obj=a1;
		
		a1=null;
		a2=null;
				
		System.gc();
		
		System.out.println("Main done");
		
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("DDDDDDDDDD");
	}
}
