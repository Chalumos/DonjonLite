package personnage;

import Objet.Arme;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Aventurier extends Personne {
	// Donjon
	private int positionY;
	private int positionX;

	//Attributs

	private int bourseOr;
	
	public Aventurier() {
		super();
		positionY = 0;
		positionX = 0;
		bourseOr = 0;
		setForce(10);
		setVitesse(2);
		setVie(100);
	}

	public void seDeplacer(String deplacement){
		switch (deplacement){
			case "haut":
				setPositionY(getPositionY() + 1);
				break;
			case "bas":
				setPositionY(getPositionY() - 1);
				break;
			case "gauche":
				setPositionX(getPositionX() - 1);
				break;
			case "droite":
				setPositionX(getPositionX() + 1);
				break;
		}
	}



	public void gagnerOr(int or){
		bourseOr += or;
		System.out.println("Bien joue vous gagner plus "+or+" d'or");
		System.out.println("Votre bourse est maintenant de "+bourseOr+" d'or");
	}

	public void recupererArme(Arme armeTresor){
		System.out.println("Bien joue vous avez trouver "+armeTresor.getNom()+" une arme de puissance "+armeTresor.getForce());
		setArme(armeTresor);
	}

	@Override
	public int combattre() {
		Random random = new Random();
		int degat = random.nextInt(6);
		if (getArme() != null){
			degat += getArme().getForce();
		}
		return degat;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

}
