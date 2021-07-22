package ihm;

import model.Animal;
import model.Enclos;
import model.TypeAnimal;

import java.util.List;

public interface IHM {

    public List<Animal> getAnimalList();

    public Animal getAnimal(String name);

    public void save(String name, TypeAnimal typeAnimal, Enclos enclos, String commentaire);
}

