package dbaccess;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static utilitaire.Utilititaire.conn;
import static utilitaire.Utilititaire.connecteurBD;

public class DbTypeRegimeAlimentaire {

    public TypeRegimeAlimentaire get(int id) {
        TypeRegimeAlimentaire typeRegimeAlimentaire = null;
        ResultSet result;
        connecteurBD();
        String SQLString = "SELECT * FROM type_regime_alimentaire WHERE id=?;";
        try(PreparedStatement preparedStatement = conn.prepareStatement(SQLString)){
            preparedStatement.setInt(1,id);
            result = preparedStatement.executeQuery();
            typeRegimeAlimentaire = new TypeRegimeAlimentaire(result.getInt(1), result.getString(2));
        }catch (SQLException exception){
            exception.getStackTrace();
        }
        return typeRegimeAlimentaire;
    }
}
