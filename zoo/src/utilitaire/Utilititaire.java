package utilitaire;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import animal.Animaux;

public class Utilititaire {
	static Connection conn;
	static Statement st;
	static ResultSet rs;
	static ResultSet result;
	static Statement query = null;
	static ArrayList<Animaux> listAnim = new ArrayList<Animaux>();

	public static void connecteurBD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver ok");
			String url = "jdbc:mysql://localhost:3306/zoo";
			String utilisateur = "root";
			String password = "Nefara845.";
			conn = DriverManager.getConnection(url, utilisateur, password);
			System.out.println("Connexion bien etablie!");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void insertionAnimal() throws SQLException {
		Scanner sc = new Scanner(System.in);
		String exit = "";
		int insert = 0;
		try {
			connecteurBD();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO animal VALUES(null,?,?,?,?)");
			while (!exit.toUpperCase().equals("N")) {

				// on ne peut pas mettre
				// difdferent type de next() donc
				// ou on met un nextLine derriere le nextInt ou on met tout en netxLine
				// dc on convertit une
				// sc.nextLine(); // chaine de caracter en int avec Integer.parsInt()
				// pour pouvoir leurs appliquer nextLine()
				System.out.println("Entrer un nom pour votre animal");
				String nom1 = sc.nextLine();
				System.out.println("Entrer l'id d'un type d'animal ");
				int type_animal_id1 = Integer.parseInt(sc.nextLine());
				System.out.println("Entrer l'id d'un enclos");
				int enclos_id1 = Integer.parseInt(sc.nextLine());
				System.out.println("Entrer un commentaire ");
				String commentaire1 = sc.nextLine();

				ps.setString(1, nom1);
				ps.setInt(2, type_animal_id1);
				ps.setInt(3, enclos_id1);
				ps.setString(4, commentaire1);
				System.out.println("Voulez vous continuer? O/n");
				exit = sc.nextLine();
				insert = ps.executeUpdate();// sert a connaitre le nbre de ligne affecté uniquement. pas indispensable
			}

			System.out.println(insert);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//	public static ArrayList<Animaux>recupererTypeAnimal(){
//			int id = 0 ;
//			String name = null;
//			int typeRegimeAlimentaireId = 0 ; }}

//			 try {
//				Statement query = null;
//				query = conn.createStatement();
//				ResultSet rs = query.executeQuery("SELECT * FROM type_animal");
//				ResultSet result = query.executeQuery("SELECT * FROM enclos");
//				while  (rs.next()){
//					listAnim.add (new Animaux(rs.getInt("id"),rs.getString("name"), rs.getString("type_regime_alimentaire_id")));
//					
//					//(rs.getInt(artist_id), rs.getString(nom), rs.getString(prenom)))
//					
//				}
//				return listAnim;
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return null;
//			}
//		}
//	}

//	public static void insertionEnclos() throws SQLException {
//		Scanner sc = new Scanner(System.in);
//		String exit = "";
//		int insert = 0;
//		try {
//			connecteurBD();
//			PreparedStatement ps = conn.prepareStatement("INSERT INTO enclos VALUES(?,?,?,?);
//			while (!exit.toUpperCase().equals("N")) {
//				System.out.println("Entrer un id pour votre enclos");
//				int animal_id1 = Integer.parseInt(sc.nextLine());//on ne peut pas mettre difdferent type de next() donc on met tout en netxLine dc on convertit une chaine de caracter en int avec Integer.parsInt() pour pouvoir leurs appliquer nextLine()
//				System.out.println("Entrer un nom pour votre animal");
//				String nom1 = sc.nextLine();
//				System.out.println("Entrer l'id d'un type d'animal ");
//				int type_animal_id1 = Integer.parseInt(sc.nextLine());
//				System.out.println("Entrer l'id d'un enclos");
//				int enclos_id1 = Integer.parseInt(sc.nextLine());
//				System.out.println("Entrer un commentaire ");
//				String commentaire1 = sc.nextLine();
//
//				ps.setInt(1, animal_id1);
//				ps.setString(2, nom1);
//				ps.setInt(3, type_animal_id1);
//				ps.setInt(4, enclos_id1);
//				ps.setString(5, commentaire1);
//				System.out.println("Voulez vous continuer? O/n");
//				exit = sc.nextLine();
//				insert = ps.executeUpdate();// sert a connaitre le nbre de ligne affecté uniquement. pas indispensable
//			}
//
//			System.out.println(insert);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
// }
