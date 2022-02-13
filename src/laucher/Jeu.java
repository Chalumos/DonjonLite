package laucher;


import Monde.Monde;
import java.util.ArrayList;
import java.util.Scanner;

public class Jeu {
    Monde monde;
    boolean jeuFini;

    public Jeu() {
        this.monde = new Monde();
        this.jeuFini = false;
    }

    public void jouer() {
        System.out.println("---- Bienvenue dans donjon lite ----");
        //choisirNomAventurier();
        System.out.println("---- Etage"+(monde.getEtageActuel()+1)+" ----");
        salleActuelAventurier();
        while (!this.jeuFini) {
            deplacerPersonnage();
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
        System.out.println("---- "+monde.salleActuelle()+" ----");
        actionSalleAcuel();
        if (monde.salleActuelle().getClass().toString().equals("class Monde.salle.SalleFinEtage")){
            if( (monde.getEtageActuel()+1) == monde.getCarte().size()){
                System.out.println("---- Vous avez fini DonjonLite ----");
                jeuFini = true;
            }
            else {
                monde.setEtageActuel(monde.getEtageActuel()+1);
                monde.getAventurier().monterEtage();
                System.out.println("---- Etage"+(monde.getEtageActuel()+1)+" ----");
                salleActuelAventurier();
            }

        }
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
        }
    }
}
