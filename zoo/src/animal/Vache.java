package animal;

public class Vache extends Herbivore{
	Vache(){
		super();
		
		this.nom = "Vache";
		this.maniereDeManger = "Herbivore";
		
	}
public void seDeplacer(String activite) {
	
	// String activité car il est decrit ainsi dans animaux
}

public void manger() {
	

	System.out.println(maniereDeManger);
}
@Override
public void seDeplacer() {
	// TODO Auto-generated method stub
	
}

}



