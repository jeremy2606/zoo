package dbaccess;

import model.TypeAnimal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbTypeAnimal implements TypeAnimalInterface {
    static Statement query = null;
    List<TypeAnimal> listTypeAnimal = new ArrayList<TypeAnimal>();
    private Connection connection;

    public DbTypeAnimal(Connection conne) {
        this.connection = conne;
    }

    public TypeAnimal get(int id) {

        TypeAnimal typeAnimal = null;
        ResultSet result;
        String SQLString = "SELECT * FROM type_animal WHERE id=?;";
        try {

            PreparedStatement preparedStatement = this.connection.prepareStatement(SQLString);
            preparedStatement.setInt(1, id);

            result = preparedStatement.executeQuery();
            if (result.next()) {
                typeAnimal = new TypeAnimal(result.getInt(1), result.getString(2), result.getInt(3));
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
            query = this.connection.createStatement();
            ResultSet result = query.executeQuery("SELECT * FROM type_animal;");
            while (result.next()) {
                listTypeAnimal.add(new TypeAnimal(result.getInt(1), result.getString(2), result.getInt(3)));
            }
            result.close();
            query.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return listTypeAnimal;
    }

    public TypeAnimal getByName(String name) {
        TypeAnimal typeAnimal = null;
        ResultSet result;
        String SQLString = "SELECT * FROM type_animal WHERE name = ?;";
        try (PreparedStatement getByName = connection.prepareStatement(SQLString)) {
            getByName.setString(1, name);
            result = getByName.executeQuery();
            typeAnimal = new TypeAnimal(result.getInt(1), result.getString(2),
                    result.getInt(3));
            result.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return typeAnimal;
    }
}
