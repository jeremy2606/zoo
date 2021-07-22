package utilitaire;

import animal.Animal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Utilititaire {
    public static Connection conn;
    static Statement st;
    static ResultSet rs;
    static ResultSet result;
    static Statement query = null;
    static ArrayList<Animal> listAnim = new ArrayList<>();

    public static void connecteurBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver ok");
            String url = "jdbc:mysql://localhost:3306/zoo";
            String utilisateur = "zoouser";
            String password = "zoopassword";
            conn = DriverManager.getConnection(url, utilisateur, password);
            System.out.println("Connexion bien etablie!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
