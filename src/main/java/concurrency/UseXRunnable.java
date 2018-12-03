package concurrency;

import java.util.stream.Stream;

public class UseXRunnable {

	public static void main(String[] args) {
		Stream.iterate(0,i->i+1)
			.limit(10)
			.map(XRunnable::new)
			.map(Thread::new)
			.forEach(Thread::start);
	}

}
