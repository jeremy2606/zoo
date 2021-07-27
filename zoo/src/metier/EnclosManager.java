package metier;

import dbaccess.DaoFactory;
import dbaccess.DbEnclos;

import java.util.List;

public class EnclosManager implements Manager {

    DbEnclos dao;

    public EnclosManager() {
        dao = new DaoFactory().getEnclosDao();
    }

    @Override
    public List getAll() {
        return dao.getAll();
    }

    @Override
    public Object getByName(String name) {
        return dao.getByName(name);
    }
}
