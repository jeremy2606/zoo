package dbaccess;

import animal.Animal;

import java.util.List;

public interface AnimalInterface {

    List<Animal> getAll();

    void save(Animal animal, int enclosId, int typeAnimalId);

    void update(Animal animal, int animalId);

    void update(int animalId, int enclosId);

    void delete(Animal animal);

    Animal getById(int id);

    Animal getByName(String name);

}
