package zoo;

import core.AnimalManager;
import core.Manager;
import model.Animal;

import java.util.Arrays;
import java.util.List;

public class AppliZoo {

    public static void main(String[] args) {
        Manager<Animal> animalManager = new AnimalManager();
        Animal animal = animalManager.getByName("Gianni");
        System.out.println(animal);
    }
}

