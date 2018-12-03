package generics;

public class Pair<T> {
	private T first;
	private T second;
	
	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public T getSecond() {
		return second;
	}
	
	public Pair<T> swap(){
		return new Pair<T>(second,first);
	}
	
	//static, Class ile ilişikili olduğu için burda hangi T olduğunu belirtmek zorundayız. 
	//Generic tip obje yaratılırken verilen bir tip olduğu için class üzerinden çağrılan static methodun aldığı paremetredeki tip tamamen farklı bişey olabilir.
	public static <T> void swap(Pair<T> pair){
		T temp = pair.first;
		pair.first = pair.second;
		pair.second = temp;
	}

	@Override
	public String toString() {
		return String.format("Pair [first=%s, second=%s]", first, second);
	}
	
	
}
