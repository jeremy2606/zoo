package dbaccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbTypeEnvironnement implements TypeEnvironnementInterface {

	static Statement query = null;

	private Connection connection;
	public DbTypeEnvironnement(Connection connection) {
		this.connection = connection;
	}

	public TypeEnvironnement get(int id) {

		TypeEnvironnement typeEnvironnement = null;
		ResultSet result;
		String SQLString = "SELECT * FROM type_environnement WHERE id=?;";
		try (PreparedStatement preparedStatement = connection.prepareStatement(SQLString)){
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			result.first();
				typeEnvironnement = new TypeEnvironnement(result.getInt(1), result.getString(2));
			result.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return typeEnvironnement;
	}



	public List<TypeEnvironnement> getAll() {

		List<TypeEnvironnement> typeEnvironnementList = new ArrayList<TypeEnvironnement>();

		try {
			Statement query;
			query = this.connection.createStatement();
			ResultSet result = query.executeQuery("SELECT * FROM type_environnement;");
			while (result.next()) {
				typeEnvironnementList.add(new TypeEnvironnement(result.getInt(1), result.getString(2)));
			}
			result.close();
			query.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return typeEnvironnementList;
	}

}
