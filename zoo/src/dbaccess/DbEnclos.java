package dbaccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Animal;
import model.Enclos;

public class DbEnclos implements EnclosInterface {

    private Connection connection;

    public DbEnclos(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<Animal> getAnimalList(int id) {
        ResultSet result;
        Animal animal;
        ArrayList<Animal> listAnimal = new ArrayList<Animal>();
        String SQLString ="SELECT animal.name, type_animal.name, type_regime_alimentaire.name, animal.commentaires\n"+     
                "FROM animal\n" +
                "JOIN type_animal\n" +
                "ON animal.type_animal_id = type_animal.id\n" +
                "JOIN type_regime_alimentaire\n" +
                "ON type_animal.type_regime_alimentaire_id = type_regime_alimentaire.id\n" +
                "JOIN enclos\n" +
                "ON animal.enclos_id = enclos.id\n" +
                "WHERE enclos.id = ?;";
        try (PreparedStatement getByIdStatement = connection.prepareStatement(SQLString)) {
            getByIdStatement.setInt(1, id);
            result = getByIdStatement.executeQuery();
            while (result.next()) {
                animal = new Animal(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5));
                listAnimal.add(animal);
                result.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return listAnimal;
        
    }
    public Enclos getById(int id) {
        
        Enclos enclos = null;
        ResultSet result;
        String SQLString = "SELECT * FROM enclos where id= ?";
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
            ResultSet result = query.executeQuery("SELECT * FROM enclos");
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
	public Enclos getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}