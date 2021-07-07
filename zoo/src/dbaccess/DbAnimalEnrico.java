package dbaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DbAnimalEnrico implements AnimalInterface {

    private Connection connection;

    public DbAnimalEnrico(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Animal get(int id) {
        return null;
    }

    @Override
    public List<Animal> getAll() {
        return null;
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
