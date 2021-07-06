package dbaccess;

import static utilitaire.Utilititaire.conn;
import static utilitaire.Utilititaire.connecteurBD;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbTypeRegimeAlimentaire implements TypeRegimeAlimentaireInterface {
	List<TypeRegimeAlimentaire> listTypeRegimeAlimentaire = new ArrayList<TypeRegimeAlimentaire>();
	static Statement query = null;

	public TypeRegimeAlimentaire get(int id) {
		TypeRegimeAlimentaire typeRegimeAlimentaire = null;
		ResultSet result;
		connecteurBD();
		String SQLString = "SELECT * FROM type_regime_alimentaire WHERE id=?;";
		try (PreparedStatement preparedStatement = conn.prepareStatement(SQLString)) {
			preparedStatement.setInt(1, id);
			result = preparedStatement.executeQuery();
			typeRegimeAlimentaire = new TypeRegimeAlimentaire(result.getInt(1), result.getString(2));
		} catch (SQLException exception) {
			exception.getStackTrace();
		}
		return typeRegimeAlimentaire;
	}

	public List<TypeRegimeAlimentaire> getAll() {

		connecteurBD();
		try {
			Statement query;
			query = conn.createStatement();
			ResultSet result = query.executeQuery("SELECT * FROM type_regime_alimentaire_id");
			while (result.next()) {
				listTypeRegimeAlimentaire.add(new TypeRegimeAlimentaire(result.getInt(1), result.getString(2)));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return listTypeRegimeAlimentaire;
	}

}
