package generics.genExceptions;

import java.util.ArrayList;
import java.util.List;

public class UpperWild {

	public static void main(String[] args) {
		
		List<? extends Number> list = new ArrayList<Integer>();

	}

}
