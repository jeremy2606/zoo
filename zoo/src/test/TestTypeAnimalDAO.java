package test;

import java.util.List;

import org.junit.jupiter.api.Test;

import dbaccess.DaoFactory;
import dbaccess.DbTypeAnimal;
import dbaccess.TypeAnimal;
import junit.framework.TestCase;

class TestTypeAnimalDAO extends TestCase {

	static DbTypeAnimal dao;

	@Test
	void testGet() {
		DaoFactory df = DaoFactory.getInstance();
		dao = df.getTypeAnimalDao();
		TypeAnimal t = dao.get(1);
		// System.out.println(t);
		assertNotNull(t);
		assertEquals(1, t.getId());
	}

	@Test
	void testGetAll() {
		List<TypeAnimal> lt = dao.getAll();
		assertEquals(lt.size(), 7);
	}

}
