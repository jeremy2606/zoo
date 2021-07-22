package model;

public class TypeAnimal {

    private int id;
    private String name;
    private int regime_alim_id;

    public TypeAnimal() {
    }

    public TypeAnimal(int id, String name, int regime_alim_id) {
        this.id = id;
        this.name = name;
        this.regime_alim_id = regime_alim_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeAnimal(int regime_alim_id) {
		super();
		this.regime_alim_id = regime_alim_id;
	}

	@Override
    public String toString() {
        return "TypeAnimal{" +
                "id=" + id +
                ", name='" + name + ", regime_alim_id='" + regime_alim_id + '\'' +
                '}';
    }
}
