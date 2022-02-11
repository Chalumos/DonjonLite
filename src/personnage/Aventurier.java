package personnage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Aventurier extends Personne {
	int positionY;
	int positionX;
	int bourseOr;
	
	public Aventurier() {
		super();
		this.positionY = 0;
		this.positionX = 0;
		this.bourseOr = 0;
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
				setPositionX(getPositionY() + 1);
				break;
		}
	}

	public void gagnerOr(int or){
		bourseOr += or;
		System.out.println("Bien joue vous gagner plus "+or+" d'or");
		System.out.println("Votre bourse est maintenant de "+bourseOr+" d'or");
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
