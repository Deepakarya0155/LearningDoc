package core;

public class test4 {

	
	
	public static void revers(int i) {
		if(i==0) {
			return ;
		}else {
			System.out.println(i);
			revers(--i);
		}
	}
	public static void main(String[] args) {
		revers(5);
	}
}
