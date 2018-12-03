package ocp2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array_ArrayList {

	public static void main(String[] args) {
		String[] array = { "gerbil", "mouse" };      
		List<String> list = Arrays.asList(array); 
		for (String str: list) System.out.print(str + " "); 
		list.set(1, "test");
		System.out.println("\n" );
		for (String str: array) System.out.print(str + " ");
		array[0] = "new"; 
		System.out.println("\n" );
		for (String str: list) System.out.print(str + " "); 
		list.add("gizem");
		String[] array2 = (String[]) list.toArray(); 
		  
		
//		List<String> list1 = new ArrayList<>();
//		list1.add("gizem");
//		list1.add(1,"yamasan");
//		
//		for (String str: list1) System.out.print(str + " "); 
//		
//		list1.remove(0);
//		for (String str: list1) System.out.print( "\n" +str + " "); 

	}

}
