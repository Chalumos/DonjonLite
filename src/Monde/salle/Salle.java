package Monde.salle;


import personnage.Aventurier;

public abstract class Salle {
	private static int cptNumeroSalle;
	private int numSalle;
	private boolean salleExplore = false;

	public Salle(){
		cptNumeroSalle++;
		numSalle = cptNumeroSalle;
	}

	public abstract void actionSalle(Aventurier aventurier);


	public void setSalleExplore(boolean salleExplore) {
		this.salleExplore = salleExplore;
	}

	public boolean isSalleExplore() {
		return salleExplore;
	}

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
