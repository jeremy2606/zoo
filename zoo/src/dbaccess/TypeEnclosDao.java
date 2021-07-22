package dbaccess;

import model.TypeEnclos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TypeEnclosDao implements InterfaceDaoTypeEnclos {
	List<TypeEnclos> listTypeEnclos = new ArrayList<TypeEnclos>();
	static Statement query = null;

	private Connection c;

	public TypeEnclosDao(Connection c) {
		this.c = c;
	}

	public TypeEnclos get(int id) {
		TypeEnclos typeEnclos = null;
		ResultSet result;
		String SQLString = "SELECT * FROM type_enclos WHERE id=?;";
		try {

			PreparedStatement preparedStatement = this.c.prepareStatement(SQLString);
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeQuery();
			if (result.next()) {
				typeEnclos = new TypeEnclos(result.getInt(1), result.getString(2), result.getInt(3));
			}
			result.close();
			preparedStatement.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return typeEnclos;
	}

	public List<TypeEnclos> getAll() {

		try {
			Statement query;
			query = this.c.createStatement();
			ResultSet result = query.executeQuery("SELECT * FROM type_Enclos;");
			while (result.next()) {
				listTypeEnclos.add(new TypeEnclos(result.getInt(1), result.getString(2), result.getInt(3)));
			}
			result.close();
			query.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return listTypeEnclos;
	}

}
