package core;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class CustomClass{
	Integer id;

	public CustomClass(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "CustomClass [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomClass other = (CustomClass) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}

public class test8 {
	public static void main(String[] args) {
		Set<CustomClass> obj=new HashSet<>();
		
		obj.add(new CustomClass(1));
		obj.add(new CustomClass(2));
		obj.add(new CustomClass(1));
		obj.add(new CustomClass(2));
		
		System.out.println(obj.size());
	}
}
