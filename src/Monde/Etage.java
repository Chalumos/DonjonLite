package Monde;

import Monde.salle.Salle;
import Monde.salle.SalleFinEtage;
import Monde.salle.SalleNormal;
import Monde.salle.SalleTresor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Etage {
    int maxCarte = 2;
    Salle[][] carteEtage = new Salle[maxCarte][maxCarte];

    public Etage(){
        carteEtage[0][0] = new SalleNormal();
        carteEtage[0][1] = new SalleTresor();
        carteEtage[1][1] = new SalleFinEtage();
    }

    public Salle recuperationSalle(int y, int x){
        return carteEtage[y][x];
    }


    public ArrayList<String> salleAlentour(int y, int x){
        ArrayList<String> directionsAlentour = new ArrayList<String>();
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
