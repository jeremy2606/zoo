package animal;

import comportement.Alimentation;
import comportement.Marche;

public class Giraffe extends Animaux implements Alimentation {

	public Giraffe() {
		super();
		this.nom = " Giraffe";
		this.maniereDeManger = " herbivore";
		this.maniereDeSeDeplacer = new Marche();
	}

	@Override
	public void seDeplacer() {
		System.out.println(maniereDeSeDeplacer);
	}

	@Override
	public void manger() {
		System.out.println(maniereDeManger);

	}

	@Override
	public String toString() {
		return "Giraffe [nom=" + nom + ", maniereDeManger=" + maniereDeManger + ", maniereDeSeDeplacer="
				+ maniereDeSeDeplacer + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public void seDeplacer(String activite) {
		// TODO Auto-generated method stub
		// String activité car il est decrit ainsi dans animaux
	}
}
