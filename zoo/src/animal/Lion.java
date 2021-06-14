package animal;

import comportement.Alimentation;
import comportement.Galop;
import comportement.Marche;

public class Lion extends Carnivore implements Alimentation {

	public Lion() {
		super();
		this.nom = "lion";
		this.maniereDeManger = "carnivore" ;
		this.maniereDeSeDeplacer =  new Marche();
		this.maniereDeSeDeplacer = new Galop();
	
	}

	public void seDeplacer(String activite) {
		
		System.out.println(maniereDeSeDeplacer);
	}

	public void manger() {
		
		System.out.println(maniereDeManger);
	}

	

@Override
	public String toString() {
		return "Lion [nom=" + nom + ", typeCage=" + typeCage + ", maniereDeManger=" + maniereDeManger
				+ ", maniereDeSeDeplacer=" + maniereDeSeDeplacer + ", getNom()=" + getNom() + ", getTypeCage()="
				+ getTypeCage() + ", getManiereDeManger()=" + getManiereDeManger() + ", getManiereDeSeDeplacer()="
				+ getManiereDeSeDeplacer() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}



	


@Override
public void seDeplacer() {
	// TODO Auto-generated method stub
	
}
public void  move () {
	
	
    
	this.maniereDeSeDeplacer.seDeplacer();	
} 





	}


