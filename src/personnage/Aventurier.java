package personnage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Aventurier extends Personne {
	int positionY;
	int positionX;
	
	public Aventurier() {
		super();
		this.positionY = 0;
		this.positionX = 0;
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
