package metier;

import java.util.List;

public interface Manager<T>{

    public List<T> getAll();
    public T getByName(String name);
}
