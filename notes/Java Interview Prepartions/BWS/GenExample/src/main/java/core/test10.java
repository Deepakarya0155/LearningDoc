package core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class CustomClass1{
	Integer id;

	public CustomClass1(Integer id) {
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
		CustomClass1 other = (CustomClass1) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}

public class test10 {
	public static void main(String[] args) {
		List<CustomClass1> obj=new ArrayList<>();
		
		obj.add(new CustomClass1(1));
		obj.add(new CustomClass1(2));
		obj.add(new CustomClass1(1));
		obj.add(new CustomClass1(2));
		
		System.out.println(obj.size());
	}
}
