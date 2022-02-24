package test;

public class GCdemo {

	public static void main(String[] args) {
		GCdemo d=new GCdemo();
		d=null;
		System.gc();
		System.out.println("main done");
	}
	
	@Override
	protected void finalize() throws Throwable {
				
				System.out.println("Garbage collected");
	}
}
