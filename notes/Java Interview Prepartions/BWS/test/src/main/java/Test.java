import java.util.Scanner;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		String a="ABC";
		System.out.println("Enter string");
		String b=scan.next();
		
		if(b.split(a).length>0) {
			System.out.println(false);
		}else {
//			System.out.println(b.indexOf(a));
			int i=0;
			int count=0;
			while(b.indexOf(a,i)>-1) {
				i=b.indexOf(a,i);
				i++;
				count++;
			}
			System.out.println(count);
		}
		
	}
}
