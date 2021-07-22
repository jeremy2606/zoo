package dbaccess;

import model.Enclos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbEnclos implements EnclosInterface {

    private Connection connection;

    public DbEnclos(Connection connection) {
        this.connection = connection;
    }

    public Enclos get(int id) {

        Enclos enclos = null;
        ResultSet result;
        String SQLString = "SELECT * FROM enclos WHERE id=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLString);
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                enclos = new Enclos(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4));
            }
            result.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return enclos;
    }

    public List<Enclos> getAll() {
        List<Enclos> listEnclos = new ArrayList<>();
        try {
            Statement query;
            query = connection.createStatement();
            ResultSet result = query.executeQuery("SELECT * FROM animal;");
            while (result.next()) {
                listEnclos.add(new Enclos(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4)));
            }
            result.close();
            query.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return listEnclos;
    }

    @Override
    public void save(Enclos enclos) {
        String SQLString = "INSERT INTO enclos (name, type_enclos_id, zoo_id)VALUES (?,?,?) ;";
        try (PreparedStatement saveEnclos = connection.prepareStatement(SQLString)) {
            saveEnclos.setString(1, enclos.getName());
            saveEnclos.setInt(2, enclos.getTypeEnclosId());
            saveEnclos.setInt(3, enclos.getZooId());
            saveEnclos.executeUpdate();
            connection.commit();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


    @Override
    public void update(Enclos enclos) {
        String SQLString = "UPDATE enclos SET name=?, type_enclos_id=?, zoo_id=? " +
                "WHERE id = ?;";
        try (PreparedStatement updateEnclos = connection.prepareStatement(SQLString)) {
            updateEnclos.setString(1, enclos.getName());
            updateEnclos.setInt(2, enclos.getTypeEnclosId());
            updateEnclos.setInt(3, enclos.getZooId());
            updateEnclos.setInt(4, enclos.getId());
            updateEnclos.executeUpdate();
            connection.commit();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void delete(Enclos enclos) {
        String SQLString = "DELETE FROM enclos WHERE id=?;";
        try (PreparedStatement updateEnclos = connection.prepareStatement(SQLString)) {
            updateEnclos.setInt(1, enclos.getId());
            updateEnclos.executeUpdate();
            connection.commit();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

}
