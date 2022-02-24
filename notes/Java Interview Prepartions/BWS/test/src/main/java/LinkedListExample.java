import java.util.LinkedList;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;

class ThreadA extends Thread{
	LinkedListExample ojb;
	public ThreadA(LinkedListExample ojb) {
		this.ojb=ojb;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000*2);
			ojb.flag=false;
			System.out.println("A completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class ThreadB extends Thread{
	
	boolean flag=false;
	
	
	

	public ThreadB(boolean flag) {
		super();
		this.flag = flag;
	}




	@Override
	public void run() {
		while(flag) {
			System.out.println("Hello world");
		}
	}
}

public class LinkedListExample {
	
	AtomicInteger it=new AtomicInteger(1);
	
	public static void main(String[] args) throws InterruptedException {
	
		TreeSet<Integer> set=new TreeSet<Integer>();
		
		set.add(1);
		set.add(-5);
		set.add(4);
		set.add(7);
		
		System.out.println(set.floor(7)-7);
		System.out.println(set.ceiling(7)-7);
	
	}
	
	
}
