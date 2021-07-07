package dbaccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbAnimal implements AnimalInterface {

    private Connection connection;

    public DbAnimal(Connection connection) {
        this.connection = connection;
    }

    public AnimalDTO get(int id) {

        AnimalDTO animalDTO = null;
        ResultSet result;
        String SQLString = "SELECT * FROM animal WHERE id=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQLString);
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeQuery();
            if (result.next()) {
                animalDTO = new AnimalDTO(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4), result.getString(5));
            }
            result.close();
            preparedStatement.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return animalDTO;
    }

    public List<AnimalDTO> getAll() {
        List<AnimalDTO> listAnimalDTO = new ArrayList<>();
        try {
            Statement query;
            query = connection.createStatement();
            ResultSet result = query.executeQuery("SELECT * FROM animal;");
            while (result.next()) {
                listAnimalDTO.add(new AnimalDTO(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4), result.getString(5)));
            }
            result.close();
            query.close();
        } catch (SQLException se) {
            se.printStackTrace();
        }
        return listAnimalDTO;
    }

    @Override
    public void save(AnimalDTO animalDTO) {
        String SQLString = "INSERT INTO animal (name, type_animal_id, enclos_id, commentaires)VALUES (?,?,?,?) ;";
        try (PreparedStatement saveAnimal = connection.prepareStatement(SQLString)) {
            saveAnimal.setString(1, animalDTO.getName());
            saveAnimal.setInt(2, animalDTO.getTypeAnimalId());
            saveAnimal.setInt(3, animalDTO.getEnclosId());
            saveAnimal.setString(4, animalDTO.getCommentaires());
            saveAnimal.executeUpdate();
            connection.commit();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }


    @Override
    public void update(AnimalDTO animalDTO) {
        String SQLString = "UPDATE animal SET name=?, type_animal_id=?, enclos_id=?, commentaires=? " +
                "WHERE id = ?;";
        try (PreparedStatement updateAnimal = connection.prepareStatement(SQLString)) {
            updateAnimal.setString(1, animalDTO.getName());
            updateAnimal.setInt(2, animalDTO.getTypeAnimalId());
            updateAnimal.setInt(3, animalDTO.getEnclosId());
            updateAnimal.setString(4, animalDTO.getCommentaires());
            updateAnimal.setInt(5, animalDTO.getId());
            updateAnimal.executeUpdate();
            connection.commit();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void delete(AnimalDTO animalDTO) {
        String SQLString = "DELETE FROM animal WHERE id=?;";
        try (PreparedStatement updateAnimal = connection.prepareStatement(SQLString)) {
            updateAnimal.setInt(1, animalDTO.getId());
            updateAnimal.executeUpdate();
            connection.commit();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
