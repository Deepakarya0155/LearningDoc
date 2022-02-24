package core;

public class test6 {

	public static int f1(int a,int b) {
		try {
			System.out.println(a/b);
			return 1;
		}catch(Exception e) {
			System.out.println("Exception");
			return 2;
		}finally {
			System.out.println("Finally");
			return 3;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(f1(5,0));
	}
}
