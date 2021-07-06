package dbaccess;

public class Animal {

    private int id;
    private String name;
    private int typeAnimalId;
    private int enclosId;
    private String commentaires;

    public Animal(int id, String name, int typeAnimalId, int enclosId, String commentaires) {
        this.id = id;
        this.name = name;
        this.typeAnimalId = typeAnimalId;
        this.enclosId = enclosId;
        this.commentaires = commentaires;
    }

    public Animal() {
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

    public int getTypeAnimalId() {
        return typeAnimalId;
    }

    public void setTypeAnimalId(int typeAnimalId) {
        this.typeAnimalId = typeAnimalId;
    }

    public int getEnclosId() {
        return enclosId;
    }

    public void setEnclosId(int enclosId) {
        this.enclosId = enclosId;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeAnimalId=" + typeAnimalId +
                ", enclosId=" + enclosId +
                ", commentaires='" + commentaires + '\'' +
                '}';
    }
}
