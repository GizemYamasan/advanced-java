package generics.wildcards;

import java.util.Arrays;
import java.util.List;

public class HRDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Employee> employees = Arrays.asList(new Employee("Bart"),new Employee("Homer"),
				                                 new Employee("Lisa"),new Employee("Maggie"));
		
		List<Salaried> salarieds = Arrays.asList(new Salaried("Kyle"),new Salaried("Stan"),
												 new Salaried("Kenny"),new Salaried("Cartman"));
		
		System.out.println(employees);
		System.out.println(salarieds);
		
		HR.printEmpNames(employees);
//		HR.printEmpNames(salarieds);//does not compile
		
//		List<Employee> emp = salarieds;
//		emp.add(new Employee("abc"));
		
		HR.printEmpAndSubClassNames(salarieds);
		
		HR.printAllFiltered(employees, e -> e.toString().length() %2 == 0);
	}

}
