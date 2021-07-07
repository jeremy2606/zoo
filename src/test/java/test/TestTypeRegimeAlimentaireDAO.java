package test;

import dbaccess.DaoFactory;
import dbaccess.DbTypeRegimeAlimentaire;
import dbaccess.TypeRegimeAlimentaire;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TestTypeRegimeAlimentaireDAO {

    static DbTypeRegimeAlimentaire dao;

    @Test
    void testGet() {
        DaoFactory df = DaoFactory.getInstance();
        dao = df.getTypeRegimeAlimentaireDao();
        TypeRegimeAlimentaire t = dao.get(1);
        // System.out.println(t);
        assertNotNull(t);
        assertEquals(1, t.getId());
    }

    @Test
    void testGetAll() {
        List<TypeRegimeAlimentaire> lt = dao.getAll();
        assertEquals(lt.size(), 3);
    }

}
