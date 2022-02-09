package Monde;

import Monde.salle.Salle;
import Monde.salle.SalleNormal;
import Monde.salle.SalleTresor;

public class Etage {
    Salle[][] carteEtage = new Salle[2][2];

    public Etage(){
        carteEtage[0][0] = new SalleNormal();
        carteEtage[0][1] = new SalleTresor();
    }

    public Salle RecuperationSalle(int y, int x){
        return carteEtage[y][x];
    }
}
