package cages;

import java.util.ArrayList;

import animal.Animaux;

public class EnclosStandard extends Cage {
	
	public Environnement environnement;
	
	public EnclosStandard() {

	}
	public EnclosStandard(String nomCage, ArrayList<Animaux> listeAnim,int surface, double longueur, double largeur, double hauteur, String typeCage, Environnement environnement) {
		super(nomCage, listeAnim, surface,longueur, largeur, hauteur, typeCage,  environnement);
		// TODO Auto-generated constructor stub
	}
}

