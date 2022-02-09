package Monde.salle;


import personnage.Aventurier;

public abstract class Salle {
	private static int cptNumeroSalle;
	private int numSalle;

	public Salle(){
		cptNumeroSalle++;
		numSalle = cptNumeroSalle;
	}

	public abstract void actionSalle(Aventurier aventurier);


	public static int getCptNumeroSalle() {
		return cptNumeroSalle;
	}

	public static void setCptNumeroSalle(int cptNumeroSalle) {
		Salle.cptNumeroSalle = cptNumeroSalle;
	}

	public int getNumSalle() {
		return numSalle;
	}

	public void setNumSalle(int numSalle) {
		this.numSalle = numSalle;
	}

	@Override
	public String toString() {
		return "Salle n°"+ numSalle;
	}
}
