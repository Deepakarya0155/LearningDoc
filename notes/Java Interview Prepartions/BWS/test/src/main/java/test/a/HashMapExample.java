package test.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;



public class HashMapExample<T> {

	public static void main(String[] args) {
		
//		List<Integer> ar=new CopyOnWriteArrayList<Integer>(); 
//		ar.add(1);
//		ar.add(2);
//		ar.add(3);
//		ar.add(4);
//		
//		
//		Iterator<Integer> it=	ar.iterator(); // 4
//		int i=1;
//		while(it.hasNext()) {
//			System.out.println(it.next());
//			if(i==1) {
//				ar.add(i++);
//				i++;
//			}
//		}
//		System.out.println(ar);
		
		System.out.println(System.class.getClassLoader());
		
	}
	public boolean add(T obj) {
		return true;
	}
}
