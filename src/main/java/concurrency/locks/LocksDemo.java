package concurrency.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class LocksDemo {
	
	private Counter counter = new Counter();
	private SynchCounter scounter = new SynchCounter();
	private LockCounter lcounter = new LockCounter();
	private AtomicCounter acounter = new AtomicCounter();
	
	public static void main(String[] args) {
		LocksDemo demo = new LocksDemo();
		demo.demoCounter();
		demo.demoSyncCounter();
		demo.demoLockCounter();
		demo.demoAtomicCounter();

	}

	public void demoCounter() {
		ExecutorService service = Executors.newCachedThreadPool();
		IntStream.range(0, 1000).forEach(i->service.submit(counter::increment));
		service.shutdown();
		System.out.println("Counter count=" + counter.getCount());
	}
	
	public void demoSyncCounter(){
		ExecutorService service = Executors.newCachedThreadPool();
		IntStream.range(0, 1000).forEach(i->service.submit(scounter::increment));
		service.shutdown();
		System.out.println("Synchcounter counter=" + scounter.getCount());
		
	}
	
	public void demoLockCounter(){
		ExecutorService service = Executors.newCachedThreadPool();
		IntStream.range(0, 1000).forEach(i->service.submit(lcounter::increment));
		service.shutdown();
		System.out.println("Lockcounter counter=" + lcounter.getCount());
		
	}
	
	public void demoAtomicCounter(){
		ExecutorService service = Executors.newCachedThreadPool();
		IntStream.range(0, 1000).forEach(i->service.submit(acounter::increment));
		service.shutdown();
		System.out.println("Atomiccounter counter=" + acounter.getCount());
		
	}

}
