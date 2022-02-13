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
        System.out.println( "maxCarte = "+monde.getCarte().get(0).getMaxCarte());
        Salle[][]  carte = monde.getCarte().get(0).getCarteEtage();
        for (int i = 0; i<monde.getCarte().get(0).getMaxCarte(); i++){
            for (int j = 0; j<monde.getCarte().get(0).getMaxCarte(); j++){
                if(carte[i][j] != null)
                    System.out.println(carte[i][j] + "[y:" + i + " x:" + j + "]");
            }
        }

        /*
        while (!this.jeuFini) {
            System.out.println("---- Bienvenue dans donjon lite ----");
            //choisirNomAventurier();
            salleActuelAventurier();
            while (!monde.salleActuelle().getClass().toString().equals("class Monde.salle.SalleFinEtage")){
                deplacerPersonnage();
            }

            jeuFini = true;
        }
         */
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
        System.out.println("Les directions possibles : "+ directionsAlentour);
        System.out.println("Dans quelle direction voulez-vous aller ?");
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
