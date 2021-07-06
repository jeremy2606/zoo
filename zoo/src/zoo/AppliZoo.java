package zoo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import dbaccess.DaoFactory;
import dbaccess.DbTypeRegimeAlimentaire;
import dbaccess.TypeRegimeAlimentaire;
import ihm.Interaction;
import utilitaire.Utilititaire;

public class AppliZoo {

	public Zoo1 zoo;
	public Interaction inter;

	AppliZoo(Zoo1 zoo, Interaction inter) {
		this.zoo = zoo;
		this.inter = inter;
	}

	public static void main(String[] args) throws InterruptedException, Exception {

		// ObjectOutputStream oout = null;

//		Vautour vautour1 = new Vautour();
//		Vautour vautour2 = new Vautour();
//		Lion lion1 = new Lion();
//		Vache Vache1 = new Vache();
//		Ours ours1 = new Ours();
//
//		// Zoo zoo = new Zoo(listCage);
//		// System.out.println(zoo.toString());
//
//		Plante plante1 = new Plante("Sapin", 250, "");
//		Plante plante2 = new Plante("cedre", 280, "");
//
//		ArrayList<Animaux> listAnimaux = new ArrayList<Animaux>();
//
//		ArrayList<Acteur> listActeur = new ArrayList<Acteur>();
//		listActeur.add(vautour1);
//		listActeur.add(vautour2);
//		listActeur.add(ours1);
//		listActeur.add(lion1);
		DaoFactory df = DaoFactory.getInstance();
		DbTypeRegimeAlimentaire dtra = df.getTypeRegimeAlimentaireDao();
		TypeRegimeAlimentaire ta = dtra.get(1);
		System.out.println(ta);
		// listActeur.add(plante2);
		// listActeur.add(plante1);

		// Zoo1 zoo = new Zoo1(listCage);
		// Zoo1 zoo2 = new Zoo1(listCage);

//		File file = new File("simba.xml");// simba = file
//		ZooXMLGenerator(zoo, file);
//
//		Zoo1 zoo3 = ZooXMLParser(file);
//		System.out.println(zoo3);

//		try {
//
//			// ecrire un animal dans le fichier
//
//			FileOutputStream fileOut = new FileOutputStream("ours.txt");// sans donner l adresse excact ou on veut qu il
//																		// soit il le met auto dans le dossier racine
//			ObjectOutputStream oout = new ObjectOutputStream(fileOut);
//			oout.writeObject(ours1);
//			oout.flush();// pour vider le tampon dans le fichier
//			oout.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}

		// On cr�e un objet de la classe FileInputStream qui repr�sente le fichier
		// contenant
		// l'objet s�rialis� puis un objet de type ObjectInputStream en lui passant le
		// fichier
		// en param�tre. Un appel � la m�thode readObject() de la classe
		// ObjectInputStream retourne l'objet avec un type Object.
		// Un cast est n�cessaire pour obtenir le type de l'objet. La m�thode close()
		// permet
		// de terminer l'op�ration et lib�rer les ressources.
//		try {
//			FileInputStream fichierInStream = new FileInputStream("ours.txt");
//			ObjectInputStream ois = new ObjectInputStream(fichierInStream);
//			Ours ours3 = (Ours) ois.readObject();
//			System.out.println("ours lu du fichier " + ours3.toString());
//			ois.close();
//		} catch (final Exception e) {
//			e.printStackTrace();
//		}
		// } catch (final ClassNotFoundException eMuph) {
		// e.printStackTrace();
		// }
		// finally {
		// try {
		//
		// if (ois != null) {
		// ois.close();
		// }
		// } catch (final IOException ex) {
		// ex.printStackTrace();
		// }
		// }

		// while(true) {
		// for (Acteur act : listActeurs ) {
		//
		// System.out.println(act.toString());
		// //System.out.println(act.getClass());
		// if(!act.getClass().getClass().equals("plante")) {
		// ((Animaux) act).seDeplacer();
		// Thread.sleep(1000);
		// ((Animaux) act).manger();
		// Thread.sleep(1000);
		//
		// }
//		Interaction interactionConsole = new Console();
//		AppliZoo appliZoo = new AppliZoo(new Zoo1(listCage), new Console());
//		appliZoo.inter.affichageMenu();
//		appliZoo.inter.choixMenu(appliZoo.zoo);
		try {
			Utilititaire.insertionAnimal();// on doit declarer la methode
			// d'utilitaire dans le mai
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void ZooXMLGenerator(Zoo1 zoo, File file) {

		XMLEncoder e;
		try {
			e = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(file)));
			e.writeObject(zoo);
			e.close();
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}

	}

	public static Zoo1 ZooXMLParser(File file) {
		Zoo1 result = null;
		try {
			XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(file)));
			result = (Zoo1) decoder.readObject();
			decoder.close();
		} catch (FileNotFoundException | ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}
}
