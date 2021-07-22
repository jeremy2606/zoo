package cages;

import animal.Animal;

import java.util.ArrayList;

public class Aquarium extends Cage {
	public Environnement environnement;

	public Aquarium (String nomCage, ArrayList<Animal> listeAnim, int surface, double longueur, double largeur, double hauteur, String typeCage, Environnement environnement) {
		super(nomCage, listeAnim, surface,longueur, largeur, hauteur, typeCage,  environnement);
		// TODO Auto-generated constructor stub
	}

}
