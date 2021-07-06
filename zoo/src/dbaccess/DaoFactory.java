package dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {
	private Connection conn;
	private static String user = "zoouser";
	private static String pwd = "zoopassword";

	public DaoFactory() {
		try {
			Class driver = Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/culture_advisor", user, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	Connection getInstance() {
		if(conn==null) {
			new DaoFactory();
		}
		return this.conn;
	}
	
	public DbTypeAnimal getTypeAnimalDao() {
		return new DbTypeAnimal(this.getInstance());
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
