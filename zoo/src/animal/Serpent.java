package animal;

import comportement.Alimentation;
import comportement.Ramper;

public class Serpent extends Animaux implements Alimentation {

	public Serpent() {
		super();
		this.nom = " Serpent";
		this.maniereDeManger = " carnivore";
		this.maniereDeSeDeplacer = new Ramper();
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
		return "Serpent [nom=" + nom + ", maniereDeManger=" + maniereDeManger + ", maniereDeSeDeplacer="
				+ maniereDeSeDeplacer + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public void seDeplacer(String activite) {
		// TODO Auto-generated method stub
		// String activité car il est decrit ainsi dans animaux
	}
}
