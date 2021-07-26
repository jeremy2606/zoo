package metier;

import java.util.List;

public interface Manager<T> {
	// T =) type general
	public List<T> getAll();

	public T getByName(String name);
}
