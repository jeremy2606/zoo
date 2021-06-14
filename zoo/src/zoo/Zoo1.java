package zoo;

import java.util.ArrayList;

import animal.Animaux;
import cages.Cage;

public class Zoo1 {
	
	
	ArrayList<Cage> listeCg;
	public Zoo1() {
		this.listeCg = new ArrayList<>();
	}
	public Zoo1(ArrayList<Cage> listeCg) {
		this.listeCg = listeCg;
	}

	@Override
	public String toString() {
		return "Zoo1 [listeCg=" + listeCg + ", getListeCg()=" + getListeCg() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public ArrayList<Cage> getListeCg() {
		return listeCg;
	}

	public void setListeCg(ArrayList<Cage> listeCg) {
		this.listeCg = listeCg;
	}

	
	void ajouterAnimal(Animaux ours1, Cage cg1) {
		
	}
	
//	public void ArrayList<Cage> trouverCageAdaptees(Animaux anim);
public boolean verifierSiCageAdapte(Animaux anim) {
	return false;
	//if'(true)(cg1.
	//
}
}
