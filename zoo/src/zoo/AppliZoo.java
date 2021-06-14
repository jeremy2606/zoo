package zoo;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;

import animal.Animaux;
import animal.Ours;
import animal.Vautour;
import cages.Cage;
import cages.EnclosStandard;
import cages.Savane;
import cages.Voliere;
public class AppliZoo {

	public	Zoo1 zoo ;
	public Interaction inter;

	AppliZoo(Zoo1 zoo, Interaction inter){
		this.zoo = zoo;
		this.inter = inter;
	}


	public static void main(String[] args) throws InterruptedException, Exception {

		//ObjectOutputStream oout = null;


		Ours ours1 = new Ours();
		Ours ours2 = new Ours();

		ArrayList<Animaux> listOurs = new ArrayList<Animaux>();
		listOurs.add(ours2);
		listOurs.add(ours1);

		Vautour vaut1 = new Vautour();
		Vautour vaut2 = new Vautour();
		System.out.println(vaut1.nom);
		vaut2.manger();
		vaut1.seDeplacer();
		ArrayList<Animaux> listvautour = new ArrayList<Animaux>();
		listOurs.add(vaut2);
		listOurs.add(vaut1);

		EnclosStandard cg1 = new EnclosStandard("Cage d'Ours", listOurs, 180, 158,165,526, "metal", new Savane());
		Voliere cg2 = new Voliere("Cage de Vautours", listvautour, 140,156, 589, 756, "titane", new Savane());


		ArrayList<Cage> listCage = new ArrayList<Cage>();
		listCage.add(cg1);
		listCage.add(cg2);

		//Zoo zoo = new Zoo(listCage);
		//System.out.println(zoo.toString());

		Plante plante1=new Plante( "Sapin", 250, "");
		Plante plante2=new Plante( "cedre", 280, "");




		ArrayList<Acteur> listActeurs = new ArrayList<Acteur>();
		listActeurs.add(vaut1);
		listActeurs.add(vaut2);
		listActeurs.add(ours1);
		listActeurs.add(ours2);
		listActeurs.add(plante2);
		listActeurs.add(plante1);



		Zoo1 zoo = new Zoo1(listCage);
		Zoo1 zoo2 = new Zoo1(listCage);

		File toto =new File("simba.xml");
		ZooXMLGenerator(zoo, toto);
		
		Zoo1 zoo3= ZooXMLParser(toto);
		System.out.println(zoo3);


		try {


			// ecrire un animal dans le fichier

			FileOutputStream fileOut = new FileOutputStream("ours.txt");//sans donner l adresse excact ou on veut qu il soit il le met auto dans le dossier racine
			ObjectOutputStream oout = new ObjectOutputStream(fileOut);
			oout.writeObject(ours1);
			oout.flush();// pour vider le tampon dans le fichier
			oout.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//On crée un objet de la classe FileInputStream qui représente le fichier contenant 
		//l'objet sérialisé puis un objet de type ObjectInputStream en lui passant le fichier
		//en paramètre. Un appel à la méthode readObject() de la classe ObjectInputStream retourne l'objet avec un type Object.
		//Un cast est nécessaire pour obtenir le type de l'objet. La méthode close() permet
		//de terminer l'opération et libérer les ressources.
		try {
			FileInputStream fichierInStream = new FileInputStream("ours.txt");
			ObjectInputStream ois = new ObjectInputStream(fichierInStream);
			Ours ours3 = (Ours) ois.readObject();	
			System.out.println("ours lu du fichier " + ours3.toString());
			ois.close();
		} 
		catch (final Exception e) {
			e.printStackTrace();
		}
		//	    } catch (final ClassNotFoundException e) {
		//	      e.printStackTrace();
		//	    } 
		//	finally {
		//	      try {
		//	        
		//			if (ois != null) {
		//	          ois.close();
		//	        }
		//	      } catch (final IOException ex) {
		//	        ex.printStackTrace();
		//	      }
		//	    }











		//	while(true) {
		//		for (Acteur act : listActeurs ) {
		//			
		//			System.out.println(act.toString());
		//			//System.out.println(act.getClass());
		//			if(!act.getClass().getClass().equals("plante")) {
		//				((Animaux) act).seDeplacer();
		//				Thread.sleep(1000);
		//				((Animaux) act).manger();
		//				Thread.sleep(1000);
		//				
		//			}
		Interaction interactionConsole = new Console();
		AppliZoo appliZoo = new AppliZoo(new Zoo1(listCage), new Console());
		//appliZoo.inter.affichageMenu();
		//appliZoo.inter.choixMenu(appliZoo.zoo );


	}

	public static void ZooXMLGenerator(Zoo1 zoo, File file){

		XMLEncoder e ;
		try {
			e = new XMLEncoder(
					new BufferedOutputStream(
							new FileOutputStream(file)));
			e.writeObject(zoo);
			e.close();
		} catch (FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		}







	}
	public static Zoo1 ZooXMLParser(File file) {
		Zoo1 result = null;
		try {
			XMLDecoder  decoder = new XMLDecoder(
					new BufferedInputStream(
							new FileInputStream(file)));
			result = (Zoo1) decoder.readObject();
			decoder.close(); 
		} catch (FileNotFoundException | ArrayIndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return result;
	}



}
