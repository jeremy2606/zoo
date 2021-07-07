package ihm;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class IhmConsole {

    Scanner scanner = new Scanner(System.in);

    public int displayMenu(List<String> elementsList) {
        int choice = 0;
        System.out.println("Choisissez une action :");
        do {
            for (int i = 0; i < elementsList.size(); i++) {
                System.out.println(i + 1 + ". " + elementsList.get(i));
            }
            System.out.println();
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException erreur) {
                System.out.println("vous devez choisir le numéro correspondant à l'element de menu choisi sans le '.'");
                scanner.next();
                choice = 0;
            }
        } while ((choice == 0)||(choice > elementsList.size()));
        return choice;
    }
}
