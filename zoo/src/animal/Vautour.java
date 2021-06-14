package animal;

import comportement.Alimentation;
import comportement.Vole;

public class Vautour extends Animaux implements Alimentation{

	public Vautour() {
		super();
		this.nom = " Vautour";
		this.maniereDeManger = " omnivore" ;
		this.maniereDeSeDeplacer = new Vole();
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
		return "Vautour [nom=" + nom + ", maniereDeManger=" + maniereDeManger + ", maniereDeSeDeplacer="
				+ maniereDeSeDeplacer + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}


	@Override
	public void seDeplacer(String activite) {
		// TODO Auto-generated method stub
		// String activité car il est decrit ainsi dans animaux
	}
}
