package dbaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbTypeRegimeAlimentaire implements TypeRegimeAlimentaireInterface {
	List<TypeRegimeAlimentaire> listTypeRegimeAlimentaire = new ArrayList<TypeRegimeAlimentaire>();
	static Statement query = null;

	private Connection c;

	public DbTypeRegimeAlimentaire(Connection c) {
		this.c = c;
	}

	public TypeRegimeAlimentaire get(int id) {

		TypeRegimeAlimentaire typeRegimeAlimentaire = null;
		ResultSet result;
		String SQLString = "SELECT * FROM type_regime_alimentaire WHERE id=?;";
		try {

			PreparedStatement preparedStatement = this.c.prepareStatement(SQLString);
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeQuery();
			if (result.next()) {
				typeRegimeAlimentaire = new TypeRegimeAlimentaire(result.getInt(1), result.getString(2));
			}
			result.close();
			preparedStatement.close();
		} catch (SQLException exception) {
			System.out.println(exception.getMessage());
		}
		return typeRegimeAlimentaire;
	}

	public List<TypeRegimeAlimentaire> getAll() {

		try {
			Statement query;
			query = this.c.createStatement();
			ResultSet result = query.executeQuery("SELECT * FROM type_regime_alimentaire_id");
			while (result.next()) {
				listTypeRegimeAlimentaire.add(new TypeRegimeAlimentaire(result.getInt(1), result.getString(2)));
			}
			result.close();
			query.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return listTypeRegimeAlimentaire;
	}

}
