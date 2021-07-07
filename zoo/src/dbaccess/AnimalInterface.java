package dbaccess;

import java.util.List;

public interface AnimalInterface {

    AnimalDTO get(int id);
    List<AnimalDTO> getAll();
    void save(AnimalDTO animalDTO);
    void update(AnimalDTO animalDTO);
    void delete(AnimalDTO animalDTO);

}
