package metier;

import java.util.List;

import dbaccess.DaoFactory;
import dbaccess.TypeEnclosDao;
import model.TypeEnclos;

public class TypeEnclosManager {
	TypeEnclosDao dao;

    public TypeEnclosManager() {
        dao = new DaoFactory().getTypeEnclosDao();
    }

    public List<TypeEnclos> getAll() {
        return dao.getAll();
    }
}
