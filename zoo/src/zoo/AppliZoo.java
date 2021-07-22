package zoo;

import java.util.Arrays;
import java.util.List;

public class AppliZoo {

    public static void main(String[] args) {
        List<String> mainMenuList = Arrays.asList("Afficher un animal");
        IhmConsole console= new IhmConsole();
        console.displayMenu(mainMenuList);
    }
}

