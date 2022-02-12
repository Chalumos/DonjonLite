package Monde.salle;

import Objet.Arme;
import personnage.Aventurier;

import java.util.Random;

public class SalleTresor extends Salle {
	int or;
	Arme arme;
	Random random = new Random();
	int typeSalle;

	public SalleTresor() {
		super();
		typeSalle = random.nextInt(2);
		if (typeSalle == 1 ){
			int force = random.nextInt(50);
			char[] nom = new char[5];
			for (int i = 0; i<5;i++) {
				nom[i] = (char) (random.nextInt(26) + 'a');
			}
			String nomArme = String.valueOf(nom);
			arme = new Arme(nomArme, force);
		}
		else  {
			this.or = random.nextInt(50);
		}
	}

	@Override
	public void actionSalle(Aventurier aventurier) {
		System.out.println("Vous ouvrez un coffre situé dans la salle");
		if (typeSalle == 1 ){
			aventurier.recupererArme(getArme());
		}
		else{
			aventurier.gagnerOr(getOr());
		}
		setSalleExplore(true);
	}

	public int getOr() {
		return or;
	}

	public Arme getArme() {
		return arme;
	}
}
