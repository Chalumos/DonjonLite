package Objet;

public class Arme {
    private int force;
    private String nom;

    public Arme(String nom, int force) {
        this.force = force;
        this.nom = nom;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
