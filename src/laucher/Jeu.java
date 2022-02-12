package laucher;

import Monde.Etage;
import Monde.Monde;
import Monde.salle.Salle;
import Monde.salle.SalleFinEtage;
import personnage.Aventurier;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Jeu {
    Monde monde;
    boolean jeuFini;

    public Jeu() {
        this.monde = new Monde();
        this.jeuFini = false;
    }

    public void jouer() {
        while (!this.jeuFini) {
            System.out.println("---- Bienvenue dans donjon lite ----");
            //choisirNomAventurier();
            salleActuelAventurier();
            while (!monde.salleActuelle().getClass().toString().equals("class Monde.salle.SalleFinEtage")){
                deplacerPersonnage();
            }

            jeuFini = true;
        }
    }
    public void choisirNomAventurier(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Donner un nom à votre aventurier !");
        String nom = scanner.next();
        monde.getAventurier().setNom(nom);
        System.out.println("Votre aventurier sera "+monde.getAventurier().getNom());
    }

    public void salleActuelAventurier() {
        System.out.println("Vous êtes actuellement dans la : "+monde.salleActuelle());
        actionSalleAcuel();
    }

    public void actionSalleAcuel() {
        if (!monde.salleActuelle().isSalleExplore()){
            monde.salleActuelle().actionSalle(monde.getAventurier());
        }
    }

    public void deplacerPersonnage(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> directionsAlentour = monde.salleAlentour();
        for (String direction : directionsAlentour) {
            System.out.println("Vous pouvez aller à "+direction);
        }
        System.out.println("Dans quelles directions voulez vous aller ?");
        String deplacement =  scanner.next().toLowerCase();
        directionsAlentour.contains(deplacement);
        if(directionsAlentour.contains(deplacement)){
            monde.getAventurier().seDeplacer(deplacement);
            salleActuelAventurier();
        }
        else {
            System.out.println("Cette direction est impossible");
            System.out.println("Dans quelles directions voulez vous aller ?");
        }

    }
}
