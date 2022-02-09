package laucher;

import Monde.Etage;
import Monde.Monde;
import Monde.salle.Salle;
import personnage.Aventurier;

public class Jeu {
    Monde monde;
    boolean jeuFini;

    public Jeu() {
        this.monde = new Monde();
        this.jeuFini = false;
    }

    public void jouer(){
        while(!this.jeuFini)
        System.out.println("---- Donjon Lite ----");
        this.salleActuelle();
        this.jeuFini = true;
    }

    public void salleActuelle(){
        Salle salleActuelle = this.monde.getCarte().get(0).RecuperationSalle(this.monde.getAventurier().getPositionY(), this.monde.getAventurier().getPositionX());
        System.out.println("Vous êtes actuellement : "+salleActuelle);
    }
}
