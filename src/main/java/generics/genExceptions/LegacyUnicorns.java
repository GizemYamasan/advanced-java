package generics.genExceptions;

import java.util.List;

public class LegacyUnicorns {
	public static void main(String[] args) {
		java.util.List<Unicorn> unicorns = new java.util.ArrayList<>();
		addUnicorn(unicorns);
		Unicorn unicorn = unicorns.get(0);    // ClassCastException
	}
	private static void addUnicorn(List unicorn) {  //COMPILER WARNING
		unicorn.add(new Dragon());
	} }
