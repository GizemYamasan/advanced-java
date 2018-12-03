package ocp2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearch1 {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Hoppy","Idea","Fluffy");
//		Comparator<String> c = Comparator.reverseOrder();
//		Collections.sort(names, c);
		int index = Collections.binarySearch(names, "Hoppy");
		System.out.println(index);

	}

}
