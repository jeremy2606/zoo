package model;

public class Animal {
    String name;
    String typeEnclos;
    String typeAnimal;
    String typeRegimeAlimentaire;
    String commentaires;

    public Animal() {
    }

    public Animal(String name, String typeEnclos, String typeAnimal,
                  String typeRegimeAlimentaire, String commentaires) {
        this.name = name;
        this.typeEnclos = typeEnclos;
        this.typeAnimal = typeAnimal;
        this.typeRegimeAlimentaire = typeRegimeAlimentaire;
        this.commentaires = commentaires;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeEnclos() {
        return typeEnclos;
    }

    public void setTypeEnclos(String typeEnclos) {
        this.typeEnclos = typeEnclos;
    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public void setTypeAnimal(String typeAnimal) {
        this.typeAnimal = typeAnimal;
    }

    public String getTypeRegimeAlimentaire() {
        return typeRegimeAlimentaire;
    }

    public void setTypeRegimeAlimentaire(String typeRegimeAlimentaire) {
        this.typeRegimeAlimentaire = typeRegimeAlimentaire;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

}
