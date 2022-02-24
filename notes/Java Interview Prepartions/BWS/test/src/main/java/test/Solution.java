package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student implements Comparable<Student>{
	private Integer id;
	private String fname;
	private Double cgpa;
	public Student(Integer id, String fname, Double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}
	public Integer getId() {
		return id;
	}
	public String getFname() {
		return fname;
	}
	public Double getCgpa() {
		return cgpa;
	}
	
	@Override
	public int compareTo(Student o) {
		if(this.getCgpa().compareTo(o.getCgpa())!=0) {
			return this.getCgpa().compareTo(o.getCgpa())*-1;
		}else if(this.getFname().compareTo(o.getFname())!=0) {
			return this.getFname().compareTo(o.getFname());
		}else {
			return this.getId().compareTo(o.getId());
		}
		
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", cgpa=" + cgpa + "]";
	}
	
	
}

//Complete the code
public class Solution
{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		
		List<Student> studentList = new ArrayList<Student>();
		while(testCases>0){
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();
			
			Student st = new Student(id, fname, cgpa);
			studentList.add(st);
			
			testCases--;
		}
        
//        Collections.sort( studentList); 
        
        PriorityQueue<Student> pq=new PriorityQueue<Student>();
        
        studentList.forEach(pq::add);
        
//       studentList.stream()
////       .map(Student::getFname)
//       . forEach(System.out::println);;;
        
        pq.forEach(System.out::println);
        
        Arrays.asList("");
	}
}
