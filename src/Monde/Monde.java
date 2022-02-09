package Monde;

import Monde.salle.Salle;
import personnage.Aventurier;

import java.util.ArrayList;
import java.util.Map;

public class Monde {
    ArrayList<Etage> carte = new ArrayList<Etage>();
    Aventurier aventurier;

    public Monde(){
        Etage etage1 = new Etage();
        carte.add(etage1);

        aventurier = new Aventurier();
    }

    public Salle salleActuelle(){
        Salle salleActuelle = this.getCarte().get(0).recuperationSalle(this.getAventurier().getPositionY(), this.getAventurier().getPositionX());

        return salleActuelle;
    }

    public ArrayList<String> salleAlentour(){
        ArrayList<String> sallesAlentour;
        sallesAlentour = getCarte().get(0).salleAlentour(this.getAventurier().getPositionY(), this.getAventurier().getPositionX());
        return sallesAlentour;
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
