package cages;

import java.util.ArrayList;

import animal.Animaux;

abstract public class Cage {
	
	String nomCage;
	ArrayList<Animaux>listeAnim;
	 int surface;
	 double longueur;
	 double largeur;
	 double hauteur;
	 String typeCage;
	 Environnement environnement;

	 public Cage() {
		 
	 }
	 
	 public Cage(String nomCage,ArrayList<Animaux>listeAnim, int surface, double longueur,double largeur,double hauteur,  String typeCage ,Environnement environnement) {
		
		this.nomCage = nomCage;
		this.listeAnim = listeAnim;
		this.surface = surface;
		this.longueur = longueur;
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.typeCage = typeCage;
		this.environnement = environnement;
	}



public  boolean isSuitableFor(Animaux anim) {
	if (anim.getTypeCage().equals(this.getClass().getName())) {
		 
		return true;
	}
	return false;
}

public void ajourAnimal(Animaux anim) {
	
}

@Override
public String toString() {
	return "Cage [nomCage=" + nomCage + ", listeAnim=" + listeAnim + ", surface=" + surface + ", longueur=" + longueur
			+ ", largeur=" + largeur + ", hauteur=" + hauteur + ", typeCage=" + typeCage + ", environnement="
			+ environnement + "]";
}

public String getNomCage() {
	return nomCage;
}

public void setNomCage(String nomCage) {
	this.nomCage = nomCage;
}

public ArrayList<Animaux> getListeAnim() {
	return listeAnim;
}

public void setListeAnim(ArrayList<Animaux> listeAnim) {
	this.listeAnim = listeAnim;
}

public int getSurface() {
	return surface;
}

public void setSurface(int surface) {
	this.surface = surface;
}

public double getLongueur() {
	return longueur;
}

public void setLongueur(double longueur) {
	this.longueur = longueur;
}

public double getLargeur() {
	return largeur;
}

public void setLargeur(double largeur) {
	this.largeur = largeur;
}

public double getHauteur() {
	return hauteur;
}

public void setHauteur(double hauteur) {
	this.hauteur = hauteur;
}

public String getTypeCage() {
	return typeCage;
}

public void setTypeCage(String typeCage) {
	this.typeCage = typeCage;
}

public Environnement getEnvironnement() {
	return environnement;
}

public void setEnvironnement(Environnement environnement) {
	this.environnement = environnement;
}
	

	
}
