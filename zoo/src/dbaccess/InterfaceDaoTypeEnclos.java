package dbaccess;

import model.TypeEnclos;

import java.util.List;

public interface InterfaceDaoTypeEnclos {
	public TypeEnclos get(int id);

	List<TypeEnclos> getAll();

}
