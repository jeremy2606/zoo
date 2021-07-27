package metier;

import dbaccess.DaoFactory;
import dbaccess.DbTypeAnimal;

import java.util.List;

public class TypeAnimalManager implements Manager{

    DbTypeAnimal dao;

    public TypeAnimalManager() {
        dao = new DaoFactory().getTypeAnimalDao();
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
