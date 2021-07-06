package test;

import org.junit.jupiter.api.Test;

import dbaccess.DaoFactory;
import dbaccess.DbTypeRegimeAlimentaire;
import dbaccess.TypeRegimeAlimentaire;
import junit.framework.TestCase;

class TestTypeRegimeAlimentaireDAO extends TestCase {

	static DbTypeRegimeAlimentaire dao;

	@Test
	void testGet() {
		DaoFactory df = DaoFactory.getInstance();
		dao = df.getTypeRegimeAlimentaireDao();
		TypeRegimeAlimentaire t = dao.get(1);
		// System.out.println(t);
		assertNotNull(t);
	}

}
