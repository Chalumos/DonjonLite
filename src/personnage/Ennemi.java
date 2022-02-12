package personnage;

import java.util.Random;

public class Ennemi extends Personne{

    public Ennemi() {
        super();
        setNom("Makris");
        setForce(2);
        setVitesse(1);
        setVie(15);
    }

    @Override
    public int combattre() {
        Random random = new Random();
        int degat = random.nextInt(6);
        return degat;
    }
}
