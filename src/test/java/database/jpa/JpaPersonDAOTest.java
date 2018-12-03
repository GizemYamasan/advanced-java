package database.jpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class JpaPersonDAOTest {
	
	private PersonDAO dao = new JpaPersonDAO(); 
	
	@Test
	public void findAll() throws Exception{
		List<Person> people = dao.findAll();
		System.out.println(people);
		assertTrue(dao.findAll().size() > 0);
	}
	
	@Test
	public void findById(){
		for(Integer id : dao.getIds()){
			assertNotNull(dao.findById(id));
		}
	}
	
	@Test
	public void save(){
		Person p = new Person("Pulaski");
		int generatedId = dao.save(p);
		assertNotNull(dao.findById(generatedId));
	}
	
	@Test
	public void delete(){
		int maxId = dao.getIds().stream()
				.mapToInt(Integer::intValue)
				.max()
				.orElse(1);
		System.out.println("maxId : " + maxId);
		Person p = dao.findById(maxId);
		dao.delete(p);
		assertNull(dao.findById(maxId));
	}
	
	@Test
	public void getIds(){
		System.out.println(dao.getIds());
	}

}
