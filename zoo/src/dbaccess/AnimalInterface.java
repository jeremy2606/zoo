package dbaccess;

import java.util.List;

public interface AnimalInterface {

    Animal get(int id);
    List<Animal> getAll();
    void save(Animal animal);
    void update(Animal animal);
    void delete(Animal animal);

}
