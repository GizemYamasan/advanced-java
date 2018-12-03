package database.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaPersonDAO implements PersonDAO{
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");

	@Override
	public List<Person> findAll() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Person> people = em.createQuery("Select p from Person p",Person.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return people;
	}

	@Override
	public Person findById(Integer id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Person person = em.find(Person.class, id);
		em.getTransaction().commit();
		em.close();
		return person;
	}

	@Override
	public Integer save(Person p) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
		em.close();
		return p.getId();
	}

	@Override
	public void delete(Person p) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(Person.class,p.getId()));
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Integer> getIds() {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		List<Integer> ids = em.createQuery("Select p.id from Person p",Integer.class).getResultList();
		return ids;
	}

}
