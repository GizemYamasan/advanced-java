package ocp2;

import java.time.LocalDate;
import java.util.Optional;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Questions {

	public static void main(String[] args) {
//		Map<Integer, Integer> map = new HashMap<>();
//		map.put(1, 10);
//		map.put(2, 20);
//		map.put(3, null);
//
//		map.merge(1, 3, (a,b) -> a + b);
//		map.merge(3, 3, (a,b) -> a + b);
//
//		System.out.println(map);
//		
//		
//		Set<String> s = new HashSet<>();
//		s.add("lion");
//		s.add("tiger");
//		s.add("bear");
//		s.forEach(System.out::println);
		
		
//		 Queue<Integer> q = new LinkedList<>();
//		 q.add(10);
//		 q.add(12);
//		 q.remove(1);
//		 System.out.print(q);
		 
//		  Set<Number> numbers = new HashSet<>();
//		  numbers.add(new Integer(86));
//		  numbers.add(75);
//		  numbers.add(new Integer(86));
//		  numbers.add(null);
//		  numbers.add(309L);
//		  Iterator iter = numbers.iterator();
//		  while (iter.hasNext())
//			  System.out.print(iter.next());
		  
//		  TreeSet<String> tree = new TreeSet<String>();
//		  tree.add("one");
//		  tree.add("One");
//		  tree.add("ONE");
//		  System.out.println(tree.size());
		  
//		  Map<Integer, Integer> map = new HashMap<>(10);
//		  for (int i = 1; i <= 10; i++) {
//			  map.put(i, i * i);
//		   }
//		   System.out.println(map.get(4));
		   
		
//		String d = Duration.ofDays(1).toString();
//		String p = Period.ofDays(1).toString();
//		 
//		boolean b1 = d == p;
//		boolean b2 = d.equals(p);
//		System.out.println(b1 + " " + b2);
//		System.out.println("p " + p + " d " + d);
//		
//		Set<? extends RuntimeException> set = new HashSet<RuntimeException>();
		
		Stream<LocalDate> s = Stream.of(LocalDate.now());
		UnaryOperator<LocalDate> u = l -> l;
		s.filter(l -> l != null).map(u).forEach(System.out::println);
		   

//		magic(Stream.empty());
		   
	}
	
	public static <T> T identity(T t) {
		   return t;
		}
	
	private static void magic(Stream<Integer> s) {  
		Optional o = s.filter(x -> x < 5).limit(3).max((x, y) -> x-y); 
		System.out.println(o.get()); 
	} 


}
