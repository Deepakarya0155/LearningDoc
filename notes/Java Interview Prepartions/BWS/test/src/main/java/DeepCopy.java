
class Name{
	String firstName;
	String lastName;
	
	
	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return "Name [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}
class Person{
	int age;
	Name name;
	
	

	public Person(int age, Name name) {
		super();
		this.age = age;
		this.name = name;
	}
	
	public Person(Person person) {
		super();
		this.age = person.age;
		this.name = new Name(person.name.firstName,person.name.lastName);
	}


	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
}

public class DeepCopy {
	public static void main(String[] args) {
		Name nm=new Name("Deepak","Arya");
		Person p1=new Person(25,nm);
		p1.age=25;
		
		
		System.out.println(p1);
 		Person p2=new Person(p1);  // Deep copy
		p2.age=10;
		System.out.println(p1);
		
		p2.name.firstName="deepu";
		
		System.out.println(p1);
	}
}
