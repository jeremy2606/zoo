package dbaccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbAnimal implements AnimalInterface {

    private Connection connection;

    public DbAnimal(Connection connection) {
        this.connection = connection;
    }

    public Animal get(int id) {

        Animal animal = null;
        ResultSet result;
        String SQLString = "SELECT * FROM animal WHERE id=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLString);
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                animal = new Animal(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4), result.getString(5));
            }
            result.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return animal;
    }

    public List<Animal> getAll() {
        List<Animal> listAnimal = new ArrayList<>();
        try {
            Statement query;
            query = connection.createStatement();
            ResultSet result = query.executeQuery("SELECT * FROM animal;");
            while (result.next()) {
                listAnimal.add(new Animal(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4), result.getString(5)));
            }
            result.close();
            query.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return listAnimal;
    }

    @Override
    public void save(Animal animal) {
        String SQLString = "INSERT INTO animal (name, type_animal_id, enclos_id, commentaires)VALUES (?,?,?,?) ;";
        try (PreparedStatement saveAnimal = connection.prepareStatement(SQLString)) {
            saveAnimal.setString(1, animal.getName());
            saveAnimal.setInt(2, animal.getTypeAnimalId());
            saveAnimal.setInt(3, animal.getEnclosId());
            saveAnimal.setString(4, animal.getCommentaires());
            saveAnimal.executeUpdate();
            connection.commit();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


    @Override
    public void update(Animal animal) {
        String SQLString = "UPDATE animal SET name=?, type_animal_id=?, enclos_id=?, commentaires=? " +
                "WHERE id = ?;";
        try (PreparedStatement updateAnimal = connection.prepareStatement(SQLString)) {
            updateAnimal.setString(1, animal.getName());
            updateAnimal.setInt(2, animal.getTypeAnimalId());
            updateAnimal.setInt(3, animal.getEnclosId());
            updateAnimal.setString(4, animal.getCommentaires());
            updateAnimal.setInt(5, animal.getId());
            updateAnimal.executeUpdate();
            connection.commit();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void delete(Animal animal) {
        String SQLString = "DELETE FROM animal WHERE id=?;";
        try (PreparedStatement updateAnimal = connection.prepareStatement(SQLString)) {
            updateAnimal.setInt(1, animal.getId());
            updateAnimal.executeUpdate();
            connection.commit();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
