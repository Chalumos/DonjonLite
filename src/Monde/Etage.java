package Monde;

import Monde.salle.*;

import java.util.ArrayList;
import java.util.Random;

public class Etage {
    Random random = new Random();
    //gerer une taille max entre 3 et 5 pour x et y
    private int maxCarte = 4 + random.nextInt(8-4);
    private Salle[][] carteEtage = new Salle[maxCarte][maxCarte];

    public Etage(){
        int x = 0;
        int y = 0;
        int cptSalle = 1;

        carteEtage[y][x] = new SalleNormal();
        int positionSalle = random.nextInt(3);
        while (cptSalle != (maxCarte*2)) {
            if(y == maxCarte-1 ){
                if(x == 0){
                    /* creation salle droite */
                    x++;
                    carteEtage[y][x] = new SalleNormal();
                    cptSalle++;
                }
            }
            if(x == maxCarte-1 ){
                if(y == 0){
                    /* creation salle droite */
                    y++;
                    carteEtage[y][x] = new SalleNormal();
                    cptSalle++;
                }
            }

            /* creation salle haut */
            if ((positionSalle) == 0 && (y + 1 != maxCarte) && (carteEtage[y+1][x] == null)) {
                y++;
                carteEtage[y][x] = new SalleNormal();
                cptSalle++;
            }
            /* creation salle bas */
            else if ((positionSalle == 1) && ((y - 1) >= 0) && (carteEtage[y-1][x] == null) ) {
                y--;
                carteEtage[y][x] = new SalleNormal();
                cptSalle++;
            }
            /* creation salle gauche */
            else if ((positionSalle == 2) && ((x - 1) >= 0) && (carteEtage[y][x-1] == null) ) {
                x--;
                carteEtage[y][x] = new SalleNormal();
                cptSalle++;
            }
            /* creation salle droite */
            else if ((positionSalle == 3) && (x + 1 != maxCarte) && (carteEtage[y][x+1] == null) ) {
                x++;
                carteEtage[y][x] = new SalleNormal();
                cptSalle++;
            } else {
                positionSalle = random.nextInt(3);
            }
        }
        /*
        carteEtage[0][1] = new SalleEnnemi();
        carteEtage[1][0] = new SalleTresor();
        carteEtage[1][1] = new SalleFinEtage();
         */
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

    public int getMaxCarte() {
        return maxCarte;
    }

    public Salle[][] getCarteEtage() {
        return carteEtage;
    }
}
