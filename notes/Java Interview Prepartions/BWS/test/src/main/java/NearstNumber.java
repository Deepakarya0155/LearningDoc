import java.util.TreeSet;

public class NearstNumber {
	
	
	
	public void f1() {
		
	}
	public int f1(String name) {
		return 1;
	}

	//-5,5,7  input 6 
	public static void main(String[] args) {
		
//		fail fast vs fail safe
		
		TreeSet<Integer> tr = new TreeSet<Integer>();
		
		Integer floordifference = null;
		Integer ceildifference = null;

		tr.add(-5);
		tr.add(5);
		tr.add(7);
		
		Integer input = 0;
		try {
			try {
				floordifference = input - tr.floor(input); //  1
			} catch (Exception e) {
				System.out.println(tr.floor(input));
			}
			try {
				ceildifference = tr.ceiling(input) - input; // 1
			} catch (Exception e) {
				System.out.println(tr.floor(input));
			}

			if (floordifference < ceildifference) {
				System.out.println(tr.floor(input));
			} else if (floordifference > ceildifference) {
				System.out.println(tr.ceiling(input));
			} else {
				System.out.println(tr.floor(input) + "," + tr.ceiling(input));
			}
		} catch (Exception e) {}
	}
}
