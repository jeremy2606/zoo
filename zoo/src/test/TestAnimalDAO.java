package test;

import java.util.List;

import org.junit.jupiter.api.Test;

import dbaccess.DaoFactory;
import dbaccess.DbAnimal;
import dbaccess.Animal;
import junit.framework.TestCase;

class TestAnimalDAO extends TestCase {

	static DbAnimal dao;

	@Test
	void testGet() {
		DaoFactory df = DaoFactory.getInstance();
		dao = df.getAnimalDao();
		Animal t = dao.get(2);
		// System.out.println(t);
		assertNotNull(t);
		assertEquals(2, t.getId());
	}

	@Test
	void testGetAll() {
		DaoFactory df = DaoFactory.getInstance();
		dao = df.getAnimalDao();
		List<Animal> lt = dao.getAll();
		assertEquals(lt.get(0).getName(), "marguerite");
	}

}
