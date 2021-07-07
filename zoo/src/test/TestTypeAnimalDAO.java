package test;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dbaccess.DaoFactory;
import dbaccess.DbTypeAnimal;
import dbaccess.TypeAnimal;
import junit.framework.TestCase;

@DisplayName("When running TypeAnimal")
class TestTypeAnimalDAO extends TestCase {
	
	static DbTypeAnimal dao;

	@Test
	@DisplayName("is getting id of animal type")
	void testGet() {
		DaoFactory df = DaoFactory.getInstance();
		dao = df.getTypeAnimalDao();
		TypeAnimal t = dao.get(1);
		// System.out.println(t);
		assertNotNull(t);
		assertEquals(1, t.getId());
	}

	@Test
	@DisplayName(" is getting all information about animal types")
	void testGetAll() {
		List<TypeAnimal> lt = dao.getAll();
		assertEquals(lt.size(), 7);
	}

}

