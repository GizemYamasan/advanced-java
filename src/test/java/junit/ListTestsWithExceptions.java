package junit;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ListTestsWithExceptions {
	
	private List<String> strings = Arrays.asList("this","is","a","list","of","strings");
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void defaultListHasSixStrings(){
		assertThat(strings.size(), is(6));
	}
	
	@Test //old JUnit 3.8
	public void nullListThrowsNPEOldStyle(){
		strings = null;
		try{
			strings.add("hello");
			fail("should have thrown an NPE");
		}catch(NullPointerException e){
			assertNull(strings);
		}
		
	}
	
	@Test(expected = NullPointerException.class)
	public void nullListThrowsNPE(){
		strings = null;
		strings.add("hello");
	}
	
	@Test
	public void nullListThrowsNPEUsingRule(){
		
		thrown.expect(ArrayIndexOutOfBoundsException.class);
		thrown.expectMessage("7");
		String[] stringArray = strings.toArray(new String[strings.size()]);
		System.out.println(stringArray[7]);
	}
	
	
}
