package dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	private static Connection conn;
	private static String user = "zoouser";
	private static String pwd = "zoopassword";

	private DaoFactory() {
	}

	public static DaoFactory getInstance() {
		if (DaoFactory.conn == null) {
			try {
				Class driver = Class.forName("com.mysql.cj.jdbc.Driver");
				DaoFactory.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", user, pwd);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return new DaoFactory();
	}

	public DbTypeAnimal getTypeAnimalDao() {
		return new DbTypeAnimal(conn);
	}

	public DbTypeRegimeAlimentaire getTypeRegimeAlimentaireDao() {
		return new DbTypeRegimeAlimentaire(conn);
	}

//	A décommenter par chacune des équipes en charge de la fonction
//	public DbAnimal getAnimalDao() {
//		return new DbAnimal(this.getInstance());
//	}
//
//	public DbEnclos getEnclosDao() {
//		return new DbEnclos(this.getInstance());
//	}

}
