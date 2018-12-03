package generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class LowerWild {

	public static void main(String[] args) {
		
		List<? super HR> l = new ArrayList<>();
		
//		l.add(new Employee()); // COMPILE ERROR
		l.add(new HR());            
		l.add(new HRofManagers());
		List<HR> hrL = new ArrayList<>();
		
		add(hrL);
	}
	
	public static void add (List<? super HRofManagers> list ){
		
	}

}
