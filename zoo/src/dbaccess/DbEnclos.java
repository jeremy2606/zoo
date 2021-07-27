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
    	String SQLString ="SELECT animal.name, type_enclos.name, type_animal.name, type_regime_alimentaire.name, animal.commentaires\n" +
                "FROM animal\n" +
                "JOIN type_animal\n" +
                "ON animal.type_animal_id = type_animal.id\n" +
                "JOIN type_regime_alimentaire\n" +
                "ON type_animal.type_regime_alimentaire_id = type_regime_alimentaire.id\n" +
                "JOIN enclos\n" +
                "ON animal.enclos_id = enclos.id\n" +
                "JOIN type_enclos\n" +
                "ON enclos.type_enclos_id = type_enclos.id\n"+
                "WHERE enclos.id = ?;";
    	try (PreparedStatement getListStatement = connection.prepareStatement(SQLString)) {
            getListStatement.setInt(1, id);
            result = getListStatement.executeQuery();
            while (result.next()) {
                animal = new Animal(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5));
                listAnimal.add(animal);
               
            }
            result.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    	System.out.println(listAnimal);
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
        System.out.println(enclos);
        return enclos;
    }

	@Override
	public Enclos getByName(String name) {
		Enclos enclos = null;
        ResultSet result;
        String SQLString = "SELECT * FROM enclos where name= ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLString);
            preparedStatement.setString(1, name);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                enclos = new Enclos(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4));
            }
            result.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println(enclos);
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
        System.out.println(listEnclos);
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
            connection.setAutoCommit(false);
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
            connection.setAutoCommit(false);
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
            connection.setAutoCommit(false);
            connection.commit();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


    public Object getByName(String name) {
        return null;
    }
}
