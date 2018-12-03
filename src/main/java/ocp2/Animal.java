package ocp2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Animal implements Comparable<Animal> {
	
	int id ;

	@Override
	public int compareTo(Animal a) {
		
		return a.id-id;
	}

	public static void main(String[] args) {
		Animal a1 = new Animal();
		Animal a2 = new Animal();
		
		a1.id = 5;
		a2.id = 7;
		
		
		List<Animal> animalList = new ArrayList<>();
		animalList.add(a2);
		animalList.add(a1);
		
		for(Animal a : animalList){
			System.out.println(a.id);
		}
		
		Collections.sort(animalList);
		for(Animal a : animalList){
			System.out.println(a.id);
		}
	}
	
	

}
