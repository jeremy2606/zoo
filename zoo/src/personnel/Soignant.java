package personnel;

public class Soignant extends Personnel {

	public Soignant() {
		super();
		
		this.profession = "Soignant"; //on a mit "profession" comme attribut de "Personel", et soignant herite de "Personnel"
		//on initialise la valeur de profession?
		// TODO Auto-generated constructor stub
	}
 public void travailler() {
	 System.out.println("Je soigne les animaux");
 }
}
