package zoo;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Console implements Interaction {

	Scanner sc = new Scanner(System.in);
	int i = sc.nextInt();

	//ArrayList<String> choixCage = new ArrayList();
	// ArrayList<String> choixCage.add();
	public void afficherZoo(Zoo1 zoo) {
		System.out.println(zoo.toString());

	}

	public void run() {
		System.out.println("Bienvenue au Zoo");

	}

	public void affichageMenu() {
		System.out.println("Faites votre choix parmis les options suivantes: ");
		System.out.println("1. Afficher le zoo");
		System.out.println("2. Ajouter un animal");
		System.out.println("3. Ajouter une cage");
		System.out.println("0. Quitter le programme");
		
	}

	public void choixMenu(Zoo1 zoo) {

		try {
			int i = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Mauvaise entrée. Reessayez");

		}
		switch (i) {
		 
		case 1 :
			
			this.afficherZoo(zoo);
			break;
		
		case 2 : 
			//a faire: ? creer une methode ajouter un animal en le declarant dans Zoo1
			break;
			

		case 3 : 
			//a faire
			break;
			

		case 0 : 
			System.exit(0);
				
		}
		

	}

}
//comment l utilisateur va passer les parametres qui vont par ex permettre de mettre un animal dans une cage ou creer un animal
//ajouter un animal
//inserer ds enclos un numero pour chaque type d enclos. 
//cree methode "ajouter un animal" ajouterAnimal (Animaux animal1); dans cage pour creer un animal (avec .un boolean qui dit si l animal rentré bien dans la cage)
//verification si ce qui est entréé est entré dans les bonnes conditionscad phrase a donner en cas d erreur de rentrée
//dans zoo : maCage.ajouterAnimal(oursMisha)
//dans zoo void afficherZoo() et
//void ajouterAnimal(Animaus animal1, Cage cg1)
//cg1.ajouterAnimal()
//verifieCageAdapte(Animaux animal1); boolean cherche parmis ce existant (exist)
//ArrayList<Cage>trouverCageAdaptes(Animaux animal1); recupere cette cage (find)
//interaction   
