package test;

import java.util.List;

import org.junit.jupiter.api.Test;

import dbaccess.DaoFactory;
import dbaccess.TypeEnclos;
import dbaccess.TypeEnclosDao;
import junit.framework.TestCase;

class TestTypeEnclosDao extends TestCase {

	TypeEnclosDao dao;

	@Test
	void testGet() {
		DaoFactory df = DaoFactory.getInstance();
		dao = df.getTypeEnclosDao();
		TypeEnclos typeEnclos = dao.get(1);
		// System.out.println(t);
		assertNotNull(typeEnclos);
		assertEquals(1, typeEnclos.getId());
	}

	@Test
	void testGetAll() {
		List<TypeEnclos> lt = dao.getAll();
		assertEquals(lt.size(), 6);
	}
}
