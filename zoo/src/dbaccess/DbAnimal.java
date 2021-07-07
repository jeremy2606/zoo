package dbaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbAnimal implements AnimalInterface {
	List<Animal> listAnimal = new ArrayList<Animal>();
	static Statement query = null;

	private Connection c;

	public DbAnimal(Connection c) {
		this.c = c;
	}

	public Animal get(int id) {

		Animal typeAnimal = null;
		ResultSet result;
		String SQLString = "SELECT * FROM animal WHERE id=?;";
		try {

			PreparedStatement preparedStatement = this.c.prepareStatement(SQLString);
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeQuery();
			if (result.next()) {
				typeAnimal = new Animal(result.getInt(1), result.getString(2),result.getInt(3),result.getInt(4), result.getString(5));
			}
			result.close();
			preparedStatement.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return typeAnimal;
	}

	public List<Animal> getAll() {

		try {
			Statement query;
			query = this.c.createStatement();
			ResultSet result = query.executeQuery("SELECT * FROM animal;");
			while (result.next()) {
				listAnimal.add(new Animal(result.getInt(1), result.getString(2),result.getInt(3),result.getInt(4), result.getString(5)));
			}
			result.close();
			query.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return listAnimal;
	}

}
