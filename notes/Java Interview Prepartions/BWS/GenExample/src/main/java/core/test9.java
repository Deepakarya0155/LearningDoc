package core;

public class test9 {
	
	public static String revString(String st) {
		if(st.length()==1) {
			return st;
		}
		else {
			return revString(st.substring(1,st.length()))+st.charAt(0);
		}
	}
	public static void main(String[] args) {
		System.out.println(revString("deepak"));
	}

}
