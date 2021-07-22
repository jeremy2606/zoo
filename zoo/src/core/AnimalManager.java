package core;

import dbaccess.DaoFactory;
import dbaccess.DbAnimal;
import model.Animal;
import model.Enclos;
import model.TypeAnimal;

import java.util.List;

public class AnimalManager {

    DbAnimal dao;

    public AnimalManager() {
        dao = new DaoFactory().getAnimalDao();
    }

    public List<Animal> getAnimalList() {
        return dao.getAll();
    }

    public Animal getAnimal(String name) {
        return dao.getByName(name);
    }

    public void save(String name, TypeAnimal typeAnimal, Enclos enclos, String commentaire){

    }
}
