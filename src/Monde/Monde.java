package Monde;

import Monde.salle.Salle;
import personnage.Aventurier;

import java.util.ArrayList;
import java.util.Map;

public class Monde {
    ArrayList<Etage> carte = new ArrayList<Etage>();
    int etageActuel = 0;
    Aventurier aventurier;

    public Monde(){
        for (int i = 0; i<10; i++ ){
            carte.add(new Etage());
        }
        aventurier = new Aventurier();
    }

    public Salle salleActuelle(){
        Salle salleActuelle = this.getCarte().get(etageActuel).recuperationSalle(this.getAventurier().getPositionY(), this.getAventurier().getPositionX());

        return salleActuelle;
    }

    public ArrayList<String> salleAlentour(){
        ArrayList<String> sallesAlentour;
        sallesAlentour = getCarte().get(etageActuel).salleAlentour(this.getAventurier().getPositionY(), this.getAventurier().getPositionX());
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

    public int getEtageActuel() {
        return etageActuel;
    }

    public void setEtageActuel(int etageActuel) {
        this.etageActuel = etageActuel;
    }
}
