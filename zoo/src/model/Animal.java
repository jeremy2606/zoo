package model;

public class Animal {

    private String prenom;
    private String race;
    private String typeEnclos;
    private String regimeAlimentaire;
    private String commentaires;

    public Animal() {
    }

    public Animal(String prenom, String race, String regimeAlimentaire, String commentaires) {
        this.prenom = prenom;
        this.race = race;
        this.regimeAlimentaire = regimeAlimentaire;
        this.commentaires = commentaires;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getRegimeAlimentaire() {
        return regimeAlimentaire;
    }

    public void setRegimeAlimentaire(String regimeAlimentaire) {
        this.regimeAlimentaire = regimeAlimentaire;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public String getTypeEnclos() {
        return typeEnclos;
    }

    public void setTypeEnclos(String typeEnclos) {
        this.typeEnclos = typeEnclos;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "prenom='" + prenom + '\'' +
                ", race='" + race + '\'' +
                ", typeEnclos='" + typeEnclos + '\'' +
                ", regimeAlimentaire='" + regimeAlimentaire + '\'' +
                ", commentaires='" + commentaires + '\'' +
                '}';
    }
}
