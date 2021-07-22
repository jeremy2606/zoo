package dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

    private Connection conn;
    private String user = "zoouser";
    private String pwd = "zoopassword";

    public DaoFactory() {
        try {
            Class driver = Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/zoo", user, pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DbTypeAnimal getTypeAnimalDao() {
        return new DbTypeAnimal(conn);
    }

    public DbAnimal getAnimalDao() {
        return new DbAnimal(conn);
    }

    public DbEnclos getEnclosDao() {
        return new DbEnclos(conn);
    }

    public DbTypeRegimeAlimentaire getTypeRegimeAlimentaireDao() {
        return new DbTypeRegimeAlimentaire(conn);
    }

    public DbTypeEnvironnement getTypeEnvironnementDao() {
        return new DbTypeEnvironnement(conn);
    }

    public TypeEnclosDao getTypeEnclosDao() {
        return new TypeEnclosDao(conn);
    }

}
