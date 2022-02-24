package test.a;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;

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
    public String getName() {
        return fname;
    }
    public Double getCgpa() {
        return cgpa;
    }
    
    @Override
    public int compareTo(Student o) {
        if(this.getCgpa().compareTo(o.getCgpa())!=0) {
            return this.getCgpa().compareTo(o.getCgpa())*-1;
        }else if(this.getName().compareTo(o.getName())!=0) {
            return this.getName().compareTo(o.getName());
        }else {
            return this.getId().compareTo(o.getId());
        }
        
    }
    @Override
    public String toString() {
        return "Student [id=" + id + ", fname=" + fname + ", cgpa=" + cgpa + "]";
    }
    
    
}
class Priorities{
    public List<Student> getStudents(List<String> events){
        Scanner scan=null;
        PriorityQueue<Student> pq=new PriorityQueue<Student>();
        List<Student> response=new ArrayList<Student>();
        for(String s:events){
            scan=new Scanner(s);
            String cmd=scan.next();
            if(cmd.equals("ENTER")){
                String name=scan.next();
                Double cgpa=scan.nextDouble();
                Integer id=scan.nextInt();
                Student st=new Student(id,name,cgpa);
                pq.add(st);
            }else if(cmd.equals("SERVED")){
               Student st= pq.remove();
               System.out.println(st);
            }
        }
        pq.forEach(response::add);
        pq.size()
        return response;
    }
}

public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();
    
    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());    
        List<String> events = new ArrayList<>();
        
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }
        
        List<Student> students = priorities.getStudents(events);
        
        
        
        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}