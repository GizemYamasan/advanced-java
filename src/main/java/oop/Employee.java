package oop;

import java.time.LocalDate;

public abstract class Employee {
	
	public static final String DEFAULT_NAME = "UNKNOWN";
	private static int nextInt;
	
	private Integer id;
	private String name;
	private LocalDate hireDate;
	
	
	
	public Employee() {
		this(DEFAULT_NAME);
	}
	
	
	public Employee(String name) {
		id = nextInt++;
		this.name = name;
		hireDate = LocalDate.now();
	}


	public Integer getId() {
		return id;
	}
	private void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract double getPay();


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", hireDate=" + hireDate + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		if (hireDate == null) {
			if (other.hireDate != null)
				return false;
		} else if (!hireDate.equals(other.hireDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Employee other = (Employee) obj;
//		if (hireDate == null) {
//			if (other.hireDate != null)
//				return false;
//		} else if (!hireDate.equals(other.hireDate))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
	

	
//	@Override
//	public String toString() {
//		return String.format("Employee{id=%d, name='%s', hireDate=%s}",
//				id, name, hireDate);
//	}
	
	
	
	
	

}
