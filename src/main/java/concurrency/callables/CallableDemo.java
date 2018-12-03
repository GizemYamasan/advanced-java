package concurrency.callables;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CallableDemo {

	public static void main(String[] args) {
		List<Callable<String>> callables = Stream.iterate(0,n->n+1)
				.limit(10)
				.map(MyCallable::new)
				.collect(Collectors.toList());
		
		ExecutorService service = Executors.newFixedThreadPool(3);
		
		try {
			List<Future<String>> futures = service.invokeAll(callables);
			for(Future<String> future : futures ){
				System.out.println(future.get());
			}
//			Function<Future<String>, String> futureToString = f -> f.toString();
//			Function<Future<String>, String> futureToString3 = (Future<String> f) -> { return f.toString(); };
//			Function<Future<String>, String> futureToString2 = new Function<Future<String>, String>() {
//				@Override
//				public String apply(Future<String> f) {
//					return f.toString();
//				}
//			};
		
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}finally{
			service.shutdown();
		}
		

	}

}
