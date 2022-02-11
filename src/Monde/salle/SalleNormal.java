package Monde.salle;

import personnage.Aventurier;

public class SalleNormal extends Salle {

	public SalleNormal() {
		super();
	}

	@Override
	public void actionSalle(Aventurier aventurier) {
		System.out.println("Il n'y a rien ici !");
		
	}

}
