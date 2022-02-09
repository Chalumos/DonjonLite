package Monde.salle;

import java.util.Random;

public class SalleTresor extends Salle {
	int or;
	
	public SalleTresor() {
		Random nbPieceOr = new Random();
		this.or = nbPieceOr.nextInt(50);
	}

	@Override
	public void actionSalle() {
		System.out.println("Bien jou� vous gagner plus "+this.or+" d'or");	
	}

}
