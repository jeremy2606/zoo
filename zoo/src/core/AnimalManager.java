package core;

import dbaccess.DaoFactory;
import dbaccess.DbAnimal;
import model.Animal;
import model.Enclos;
import model.TypeAnimal;

import java.util.List;

public class AnimalManager implements Manager{

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

    public void save(String name, TypeAnimal typeAnimal, Enclos enclos, String commentaire){

    }
}
