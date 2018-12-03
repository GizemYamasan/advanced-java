package concurrency;

public class XRunnable implements Runnable {
	
	private int id;
	
	public XRunnable(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Hello from " + this);

	}
	
	@Override
	public String toString() {
		return String.format("XRunnable[id=%d] ", id);
	}

}
