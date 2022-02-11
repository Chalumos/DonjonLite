package Monde.salle;

import personnage.Aventurier;

public class SalleMonstre extends Salle {

	@Override
	public void actionSalle(Aventurier aventurier) {
		System.out.println("Un monstre vous attaque !");	
	}

}
