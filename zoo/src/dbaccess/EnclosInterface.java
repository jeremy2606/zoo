package dbaccess;

import java.util.List;

public interface EnclosInterface {
	
	Enclos get(int id);
    List<Enclos> getAll();
    void save(Enclos enclos);
    void update(Enclos enclos);
    void delete(Enclos enclos);
}
