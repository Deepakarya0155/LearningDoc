import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee implements Comparable<Employee>{
	int id;
	int salary;
	String name;
	public Employee(int id, int salary, String name) {
		super();
		this.id = id;
		this.salary = salary;
		this.name = name;
	}
	@Override
	public int compareTo(Employee o) {
		if(this.id>o.id) {
			return 1;
		}else {
			return -1;
		}
//		return 0;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + "]";
	}
	
}

public class ComparableVsComparatorExample {
	 public static void main(String[] args) {
		List<Employee> em=new ArrayList<Employee>();
		
		em.add(new Employee(10, 100, "A"));
		em.add(new Employee(1, 500, "B"));
		em.add(new Employee(9, 200, "C"));
		em.add(new Employee(6, 400, "D"));
		
		Comparator<Employee> bySalary=new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1.salary>o2.salary) {
					return -1;
				}else {
					return 1;
				}
				
			}
			
		};
		
		Collections.sort(em);
		
		em.forEach(System.out::println);
		
		System.out.println("by salary ");
		
		Collections.sort(em,bySalary);
		
		em.forEach(System.out::println);
	}
}
