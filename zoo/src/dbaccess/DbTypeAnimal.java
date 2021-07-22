package dbaccess;

import model.TypeAnimal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbTypeAnimal implements TypeAnimalInterface {
	List<TypeAnimal> listTypeAnimal = new ArrayList<TypeAnimal>();
	static Statement query = null;

	private Connection c;

	public DbTypeAnimal(Connection c) {
		this.c = c;
	}

	public TypeAnimal get(int id) {

		TypeAnimal typeAnimal = null;
		ResultSet result;
		String SQLString = "SELECT * FROM type_animal WHERE id=?;";
		try {

			PreparedStatement preparedStatement = this.c.prepareStatement(SQLString);
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeQuery();
			if (result.next()) {
				typeAnimal = new TypeAnimal(result.getInt(1), result.getString(2),result.getInt(3));
			}
			result.close();
			preparedStatement.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return typeAnimal;
	}

	public List<TypeAnimal> getAll() {

		try {
			Statement query;
			query = this.c.createStatement();
			ResultSet result = query.executeQuery("SELECT * FROM type_animal;");
			while (result.next()) {
				listTypeAnimal.add(new TypeAnimal(result.getInt(1), result.getString(2),result.getInt(3)));
			}
			result.close();
			query.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return listTypeAnimal;
	}

}
