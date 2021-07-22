import core.AnimalManager;
import core.Manager;
import model.Animal;

public class AppliZoo {

    public static void main(String[] args) {
        Manager<Animal> animalManager = new AnimalManager();
        Animal animal = animalManager.getByName("Gianni");
        System.out.println(animal);
    }
}

