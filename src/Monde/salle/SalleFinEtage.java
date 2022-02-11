package Monde.salle;

import personnage.Aventurier;

import java.util.Random;

public class SalleFinEtage extends Salle{

    public SalleFinEtage() {
        super();
    }

    @Override
    public void actionSalle(Aventurier aventurier) {
        System.out.println("Vous êtes arrivez à la fin de cette étage");
    }
}
