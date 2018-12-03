package lambdasstreams;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.function.BiPredicate;

public class FileFilterDemo {

	public static void main(String[] args) {
		File directory = new File("./src/main/java/lambdasstreams");
		
		Arrays.stream(directory.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith("java");
			}
		})).forEach(System.out::println);
		
		
		FilenameFilter filter = (dir,name) -> name.endsWith("java");
		String[] fileNames = directory.list(filter);
		System.out.println("With Lambda");
		Arrays.stream(fileNames).forEach(System.out::println);
		
		String[] fileNames2 = directory.list(FileFilterDemo::accept);
		System.out.println("With Method References");
		Arrays.stream(fileNames2).forEach(System.out::println);
	}
	
	public static boolean accept(File dir, String name){
		return name.endsWith("java");
	}

}
