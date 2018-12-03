package datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GHashMapTest {
	
	GHashMap<Integer, String> hashMap;

	@Before
	public void init(){
		
		hashMap = new GHashMap<>();
	}
	
	@Test
	public void test_put_success() {
		
		hashMap.put(1,"gizem");
		Assert.assertEquals("gizem", hashMap.get(1));
	}
	
	@Test
	public void test_putSameKey_success() {
		hashMap.put(1,"gizem");
		hashMap.put(1,"oguzhan");
		Assert.assertEquals("oguzhan", hashMap.get(1));
	}
	
	@Test
	public void test_putAll_success(){
		
		for(int i=0;i<1000;i++){
			hashMap.put(i%100, "gizem");
			hashMap.put(i%100+31, "gizem");
		}
		
		Assert.assertEquals(hashMap.size(),131);
	}

}
