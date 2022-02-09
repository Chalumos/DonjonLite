package Monde;

import personnage.Aventurier;

import java.util.ArrayList;

public class Monde {
    ArrayList<Etage> carte = new ArrayList<Etage>();
    Aventurier aventurier;

    public Monde(){
        Etage etage1 = new Etage();
        carte.add(etage1);

        aventurier = new Aventurier();
    }

    public ArrayList<Etage> getCarte() {
        return carte;
    }

    public void setCarte(ArrayList<Etage> carte) {
        this.carte = carte;
    }

    public Aventurier getAventurier() {
        return aventurier;
    }

    public void setAventurier(Aventurier aventurier) {
        this.aventurier = aventurier;
    }
}
