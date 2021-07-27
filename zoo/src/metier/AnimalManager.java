package metier;

import dbaccess.DaoFactory;
import dbaccess.DbAnimal;
import model.Animal;

import java.util.List;

public class AnimalManager implements Manager {

    DbAnimal dao;

    public AnimalManager() {
        dao = new DaoFactory().getAnimalDao();
    }

    public List<Animal> getAll() {
        return dao.getAll();
    }

    public Animal getByName(String name) {
        return dao.getByName(name);
    }

    public void save(String name, int typeAnimalId, int enclosId, String commentaire) {
        Animal animalToSave = new Animal(name, "", "", "", commentaire);
        dao.save(animalToSave, typeAnimalId, enclosId);
    }
}