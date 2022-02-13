package Monde;

import Monde.salle.*;

import java.util.ArrayList;
import java.util.Random;

public class Etage {
    int maxCarte = 3;
    Salle[][] carteEtage = new Salle[maxCarte][maxCarte];

    public Etage(){
        carteEtage[0][0] = creationSalleAleatoire();
        carteEtage[0][1] = creationSalleAleatoire();
        carteEtage[0][2] = creationSalleAleatoire();
        carteEtage[1][0] = creationSalleAleatoire();
        carteEtage[1][1] = creationSalleAleatoire();
        carteEtage[1][2] = creationSalleAleatoire();
        carteEtage[2][0] = creationSalleAleatoire();
        carteEtage[2][1] = creationSalleAleatoire();
        carteEtage[2][2] = new SalleFinEtage();
    }

    public Salle creationSalleAleatoire() {
        Random random = new Random();
        int nbSalle = 1 + random.nextInt(4-1);
        switch (nbSalle){
            case 1 :
                return new SalleNormal();
            case 2 :
                return new SalleTresor();
            case 3 :
                return new SalleEnnemi();
            default:
                nbSalle = 1 + random.nextInt(3-1);
        }
        return null;
    }
    public Salle recuperationSalle(int y, int x){
        return carteEtage[y][x];
    }


    public ArrayList<String> salleAlentour(int y, int x){
        ArrayList<String> directionsAlentour = new ArrayList<String>();
        /*
        if (y > 0) {
            if(recuperationSalle(y - 1, x) != null){
                directionsAlentour.add("bas");
            }
        }
        if (x > 0) {
            if(recuperationSalle(y, x - 1) != null){
                directionsAlentour.add("gauche");
            }
        }
        */
        if ( (y+1) < maxCarte) {
            if (recuperationSalle(y + 1, x) != null) {
                directionsAlentour.add("haut");
            }
        }
        if ( (x+1) < maxCarte) {
            if (recuperationSalle(y, x + 1) != null) {
                directionsAlentour.add("droite");
            }
        }
        return  directionsAlentour;
    }

    /*
    public Map<String,Salle> salleAlentour(int y, int x){

        Map<String,Salle> sallesAlentour = new HashMap<String,Salle>();
        for (int perimetre =-1; perimetre <= 1; perimetre++){
            if ( (perimetre != 0) && (y != 0 || perimetre != -1) && (x != 0 || perimetre != -1)) {
                Salle salle = recuperationSalle(y + perimetre, x);
                if (salle != null) {
                    if ((y + perimetre) < y ){
                        //salle bas
                        sallesAlentour.put("bas",salle);
                    }
                    else {
                        //salle haut
                        sallesAlentour.put("haut",salle);
                    }

                }
                salle = recuperationSalle(y, x + perimetre);
                if (salle != null) {
                    if ((x + perimetre) < y ){
                        //salle gauche
                        sallesAlentour.put("gauche",salle);
                    }
                    else {
                        //salle droite
                        sallesAlentour.put("droite",salle);
                    }
                }
            }
        }
        return sallesAlentour;
    }
    */
}
