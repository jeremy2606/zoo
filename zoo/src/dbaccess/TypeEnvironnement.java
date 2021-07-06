package dbaccess;

public class TypeEnvironnement {

    private int id;
    private String name;

    public TypeEnvironnement(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TypeEnvironnement() {
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

    @Override
    public String toString() {
        return "TypeEnvironnement{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
