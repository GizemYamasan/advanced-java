package concurrency.locks;

public class SynchCounter {
private int count;
	
	public synchronized void increment(){
		++count;
	}
	
	public synchronized int getCount(){
		return count;
	}

}
