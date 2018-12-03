package datastructures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GQueueTest {
	
	GQueue<String> q;
	
	
	@Before
	public void init(){
		q = new GQueue<>();
	}
	
	@Test
	public void test_addItem_success(){
		q.add("A");
		Assert.assertTrue(q.size() == 1);
		Assert.assertEquals(1, q.size());
	}
	
	@Test
	public void test_removeItem_success(){
		String  data = "A";
		q.add(data);
		String returned = q.remove();
		Assert.assertTrue(q.size() == 0);
		Assert.assertEquals(data, returned);
	}
	
	@Test
	public void test_addMultipleThanRemoveItem_success(){
		String  data = "A";
		q.add(data);
		q.add("B");
		q.add("C");
		String returned = q.remove();
		Assert.assertTrue(q.size() == 2);
		Assert.assertEquals(data, returned);
	}

}
