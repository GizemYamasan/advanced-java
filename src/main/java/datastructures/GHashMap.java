package datastructures;

public class GHashMap<K, V> {
	
	public static final double DEFAULT_THRESHOLD = 0.75;

	private Entry<K, V>[] enrtyList;
	private int counter;
	private double threshold;
	

	public GHashMap() {
		this(31,DEFAULT_THRESHOLD);
	}
	
	@SuppressWarnings("unchecked")
	public GHashMap(int size, double threshold) {
		enrtyList = new Entry[size];
		this.threshold = threshold;
		this.counter = 0;
	}
	
	


	public boolean put(K key, V value) {
		if(key == null)
            throw new IllegalArgumentException();
		int hashCode = key.hashCode();
		int index = hashCode % enrtyList.length;

		Entry<K, V> newEntry = new Entry<>(key, value);
		Entry<K, V> entry = enrtyList[index];
		
		if (entry != null) {
			if(entry.key.equals(key)){
				entry.value = value;
				return true;
			}
			while (entry.next != null) {
				if(entry.key.equals(key)){
					entry.value = value;
					return true;
				}
				entry = entry.next;
			}
			entry.next = newEntry;
		} else {
			enrtyList[index] = newEntry;
		}
		counter++;
		expandIfNeeded();
		return true;
	}

	public V get(K key) {
		if(key == null)
            throw new IllegalArgumentException();
		int hashCode = key.hashCode();
		int index = hashCode % enrtyList.length;

		Entry<K, V> entry = enrtyList[index];
		while (entry != null) {
			if (entry.key.equals(key)) {
				return entry.value;
			} else {
				entry = entry.next;
			}
		}
		throw new RuntimeException("Value not Found");
	}

	public V remove(K key) {
		V v = null;
		return v;
	}
	
	public int size(){
		return counter;
	}
	
	private void expandIfNeeded(){
		
		double fullness = (double)counter / (double)enrtyList.length;
		if(fullness > threshold){
			GHashMap<K, V> newMap = new GHashMap<>(enrtyList.length*2,threshold);
			for(int i=0; i< enrtyList.length;i++){
				Entry<K, V> e = enrtyList[i];
				while(e != null){
					newMap.put(e.key, e.value);
					e = e.next;
				}
			}
			this.enrtyList = newMap.enrtyList;
			System.out.println("c : " + counter  + " array : " + enrtyList.length);
		
		}		
	}

	private static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K k, V v) {
			this.key = k;
			this.value = v;
		}
	}
}
