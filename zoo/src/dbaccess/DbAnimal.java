package dbaccess;

import model.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbAnimal implements AnimalInterface {

    private final Connection connection;

    public DbAnimal(Connection connection) {
        this.connection = connection;
    }

    public List<Animal> getAll() {
        List<Animal> listAnimal = new ArrayList<>();
        ResultSet result = null;
        String SQLString = "SELECT animal.name, type_enclos.name, type_animal.name, type_regime_alimentaire.name, animal.commentaires\n" +
                "FROM animal\n" +
                "JOIN type_animal\n" +
                "ON animal.type_animal_id = type_animal.id\n" +
                "JOIN type_regime_alimentaire\n" +
                "ON type_animal.type_regime_alimentaire_id = type_regime_alimentaire.id\n" +
                "JOIN enclos\n" +
                "ON animal.enclos_id = enclos.id\n" +
                "JOIN type_enclos\n" +
                "ON enclos.type_enclos_id = type_enclos.id;";
        try (PreparedStatement getAllStatement = connection.prepareStatement(SQLString)) {
            result = getAllStatement.executeQuery();
            while (result.next()) {
                Animal animal = new Animal(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5));
                listAnimal.add(animal);
            }
            result.close();
        } catch (SQLException sqlException) {
            System.out.println("Un problème est survenu");
            sqlException.printStackTrace();
        }
        return listAnimal;
    }

    @Override
    public void save(Animal animal, int typeAnimalId, int enclosId) {

        String SQLString = "INSERT INTO animal (name, type_animal_id, enclos_id, commentaires) VALUES " +
                "(?,?,?,?);";
        try (PreparedStatement saveAnimal = connection.prepareStatement(SQLString)) {
            saveAnimal.setString(1, animal.getName());
            saveAnimal.setInt(2, typeAnimalId);
            saveAnimal.setInt(3, enclosId);
            saveAnimal.setString(4, animal.getCommentaires());
            saveAnimal.executeUpdate();
            //connection.commit();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void update(int animalId, int enclosId) {
        // todo : changer le type enclos suivant l'enclos id
        String SQLString = "UPDATE animal SET enclos_id = ? WHERE id = ?;";
        try (PreparedStatement updateAnimal = connection.prepareStatement(SQLString)) {
            updateAnimal.setInt(1, enclosId);
            updateAnimal.setInt(2, animalId);
            updateAnimal.executeUpdate();
            //connection.commit();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void update(Animal animal, int animalId) {
        String SQLString = "UPDATE animal SET name=?, commentaires=? WHERE id = ?;";
        try (PreparedStatement updateAnimal = connection.prepareStatement(SQLString)) {
            updateAnimal.setString(1, animal.getName());
            updateAnimal.setString(2, animal.getCommentaires());
            updateAnimal.setInt(3, animalId);
            updateAnimal.executeUpdate();
            connection.commit();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void delete(Animal animal) {
        String SQLString = "DELETE FROM animal WHERE name=?;";
        try (PreparedStatement updateAnimal = connection.prepareStatement(SQLString)) {
            updateAnimal.setString(1, animal.getName());
            updateAnimal.executeUpdate();
            connection.commit();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public Animal getById(int id) {
        Animal animal = null;
        ResultSet result;
        String SQLString = "SELECT animal.name, type_enclos.name, type_animal.name, type_regime_alimentaire.name, animal.commentaires\n" +
                "FROM animal\n" +
                "JOIN type_animal\n" +
                "ON animal.type_animal_id = type_animal.id\n" +
                "JOIN type_regime_alimentaire\n" +
                "ON type_animal.type_regime_alimentaire_id = type_regime_alimentaire.id\n" +
                "JOIN enclos\n" +
                "ON animal.enclos_id = enclos.id\n" +
                "JOIN type_enclos\n" +
                "ON enclos.type_enclos_id = type_enclos.id\n" +
                "WHERE animal.id = ?;";
        try (PreparedStatement getByIdStatement = connection.prepareStatement(SQLString)) {
            getByIdStatement.setInt(1, id);
            result = getByIdStatement.executeQuery();
            if (result.next()) {
                animal = new Animal(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5));
                result.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return animal;
    }

    @Override
    public Animal getByName(String name) {
        Animal animal = null;
        ResultSet result;
        String SQLString = "SELECT animal.name, type_enclos.name, type_animal.name, type_regime_alimentaire.name, animal.commentaires\n" +
                "FROM animal\n" +
                "JOIN type_animal\n" +
                "ON animal.type_animal_id = type_animal.id\n" +
                "JOIN type_regime_alimentaire\n" +
                "ON type_animal.type_regime_alimentaire_id = type_regime_alimentaire.id\n" +
                "JOIN enclos\n" +
                "ON animal.enclos_id = enclos.id\n" +
                "JOIN type_enclos\n" +
                "ON enclos.type_enclos_id = type_enclos.id\n" +
                "WHERE animal.name = ?;";
        try (PreparedStatement getByIdStatement = connection.prepareStatement(SQLString)) {
            getByIdStatement.setString(1, name);
            result = getByIdStatement.executeQuery();
            if (result.next()) {
                animal = new Animal(
                        result.getString(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5));
                result.close();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return animal;
    }
}
