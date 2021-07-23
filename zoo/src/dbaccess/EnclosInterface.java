package dbaccess;

import model.Animal;
import model.Enclos;

import java.util.ArrayList;
import java.util.List;

public interface EnclosInterface {
	
	Enclos getById(int id);
	Enclos getByName(String name);
	ArrayList<Animal> getAnimalList(int id);
    List<Enclos> getAll();
	void update(Enclos enclos);
    void save(Enclos enclos);
    void delete(Enclos enclos);

}
