package metier;

import java.util.List;

import dbaccess.DaoFactory;
import dbaccess.DbEnclos;
import model.Enclos;
import model.TypeEnclos;

public class EnclosManager implements Manager {

	DbEnclos dao;
	
	public EnclosManager() {
		dao = new DaoFactory().getEnclosDao();
	}

	@Override
	public List<Enclos> getAll() {
		return dao.getAll();
	}

	@Override
	public Enclos getByName(String name) {
		return dao.getByName(name);
	}
	
	public void save(int id, String name, int typeEnclosId, int zooId) {
		
	}
	

}
