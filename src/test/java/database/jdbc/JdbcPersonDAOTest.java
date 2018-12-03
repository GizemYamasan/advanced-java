package database.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class JdbcPersonDAOTest {
	
	private PersonDAO dao  = new JdbcPersonDAO();
	
	@Test
	public void findAll() throws Exception{
		List<Person> people = dao.findAll();
		System.out.println(people);
		assertTrue(people.size() > 0);
	}
	
	@Test
	public void findById (){
		for(int id : dao.getIds()){
			assertNotNull(dao.findById(id));
		}
		
	}
	
	@Test
	public void save(){
		Person p = new Person("Pulaski");
//		int before = dao.findAll().size();
//		int generatedID = dao.save(p);
//		int after = dao.findAll().size();
//		assertEquals(after, before+1);
		
		int generatedID = dao.save(p);
		assertNotNull(dao.findById(generatedID));

	}
	
	@Test
	public void delete(){
		int maxId = dao.getIds().stream()
				.mapToInt(Integer::intValue)
				.max()
				.orElse(1);
		System.out.println("maxId="+maxId);
		Person p = dao.findById(maxId);
		dao.delete(p);
		assertNull(dao.findById(maxId));
	}
	
	@Test
	public void getIds(){
		System.out.println(dao.getIds());
	}

}
