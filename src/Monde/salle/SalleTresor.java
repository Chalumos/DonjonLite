package Monde.salle;

import personnage.Aventurier;

import java.util.Random;

public class SalleTresor extends Salle {
	int or;
	
	public SalleTresor() {
		super();
		Random nbPieceOr = new Random();
		this.or = nbPieceOr.nextInt(50);
	}

	@Override
	public void actionSalle(Aventurier aventurier) {
		System.out.println("Vous ouvrez un coffre situé dans la salle");
		aventurier.gagnerOr(getOr());
	}

	public int getOr() {
		return or;
	}
}
