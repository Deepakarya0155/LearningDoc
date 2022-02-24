package core;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class CustomClass2{
	Integer id;

	public CustomClass2
	(Integer id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "CustomClass [id=" + id + "]";
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomClass2 other = (CustomClass2) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}

public class test11 {
	public static void main(String[] args) {
		Set<CustomClass2> obj=new HashSet<>();
		
		obj.add(new CustomClass2(1));
		obj.add(new CustomClass2(2));
		obj.add(new CustomClass2(1));
		obj.add(new CustomClass2(2));
		
		System.out.println(obj.size());
	}
}
