package ocp2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnimalComparator {
	
	int id;
	
	 

	public static void main(String[] args) {
		
		Comparator<AnimalComparator> animalComp = new Comparator<AnimalComparator>() {

			@Override
			public int compare(AnimalComparator a1, AnimalComparator a2) {
				
				return a2.id-a1.id;
			}
			
		};
		
		AnimalComparator a1 = new AnimalComparator();
		AnimalComparator a2 = new AnimalComparator();
		
		a1.id = 5;
		a2.id = 7;
		
		
		List<AnimalComparator> animalList = new ArrayList<AnimalComparator>();
		animalList.add(a2);
		animalList.add(a1);
		
		for(AnimalComparator a : animalList){
			System.out.println(a.id);
		}
		
		Collections.sort(animalList,animalComp);
		for(AnimalComparator a : animalList){
			System.out.println(a.id);
		}

	}

}
