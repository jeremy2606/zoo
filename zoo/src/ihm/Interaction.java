package ihm;

import zoo.Zoo1;

public interface Interaction {
	
	
	
public void afficherZoo(Zoo1 zoo); 
	

  void run(); // on les declares ici pour que zoo puisse y avoir acces


  void affichageMenu(); 
  
  void choixMenu(Zoo1 zoo);
}

