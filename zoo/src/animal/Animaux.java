package animal;

import java.io.Serializable;

import comportement.Alimentation;
import comportement.Deplacement;
import zoo.Acteur;

// public abstract class Animaux extends Acteur implements Deplacement, Alimentation, Serializable, Externalizable, Closeable, DataInput, ObjectStreamConstants, AutoCloseable{
public abstract class Animaux extends Acteur implements Deplacement, Alimentation, Serializable {

	public String nom;
	public String typeCage;
	public String maniereDeManger;
	public Deplacement maniereDeSeDeplacer;

	public abstract void seDeplacer(String activite);

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTypeCage() {
		return typeCage;
	}

	public void setTypeCage(String typeCage) {
		this.typeCage = typeCage;
	}

	public String getManiereDeManger() {
		return maniereDeManger;
	}

	public void setManiereDeManger(String maniereDeManger) {
		this.maniereDeManger = maniereDeManger;
	}

	public Deplacement getManiereDeSeDeplacer() {
		return maniereDeSeDeplacer;
	}

	public void setManiereDeSeDeplacer(Deplacement maniereDeSeDeplacer) {
		this.maniereDeSeDeplacer = maniereDeSeDeplacer;
	}

//TODO Auto-generated method stub
	public void move() {

		this.maniereDeSeDeplacer.seDeplacer();
	}
}
