package Monde.salle;

import personnage.Aventurier;
import personnage.Ennemi;

import java.util.Random;

public class SalleMonstre extends Salle {
	Ennemi ennemi;

	public SalleMonstre(){
		ennemi = new Ennemi();
	}

	@Override
	public void actionSalle(Aventurier aventurier) {
		System.out.println(ennemi.getNom()+" vous attaque !");
		combat(aventurier,ennemi);
		setSalleExplore(true);
	}

	public void combat(Aventurier aventurier, Ennemi ennemi){
		int degatAventurier = 0;
		int degatEnnemi = 0;
		while ( (ennemi.getVie() > 0) && (aventurier.getVie() > 0) ){
			if (aventurier.getVitesse() > ennemi.getVitesse()){
				attaqueAventurier(aventurier);
				attaqueEnnemi(aventurier);
			}
			else if(aventurier.getVitesse() < ennemi.getVitesse()){
				attaqueEnnemi(aventurier);
				attaqueAventurier(aventurier);
			}
			else {
				Random random = new Random();
				int priorite = random.nextInt(2);
				if (priorite == 1){
					attaqueAventurier(aventurier);
					attaqueEnnemi(aventurier);
				}
				else {
					attaqueEnnemi(aventurier);
					attaqueAventurier(aventurier);
				}
			}
		}
		if (ennemi.getVie() <= 0) {
			System.out.println("vous avez gagner le combat !!");
		}

		if (aventurier.getVie() <= 0) {
			System.out.println("vous êtes mort !!");
		}
	}

	public void attaqueAventurier(Aventurier aventurier){
		if(aventurier.getVie() > 0) {
			int degatAventurier = aventurier.combattre();
			ennemi.setVie(ennemi.getVie() - degatAventurier);
			System.out.println("vous infigez "+ degatAventurier +" à "+ennemi.getNom());
			System.out.println("il reste "+ennemi.getVie()+ " PV à "+ennemi.getNom());
		}
	}

	public void  attaqueEnnemi(Aventurier aventurier) {
		if(ennemi.getVie() > 0) {
			int degatEnnemi = ennemi.combattre();
			aventurier.setVie(aventurier.getVie() - degatEnnemi);
			System.out.println("vous perdez " + degatEnnemi + " PV");
			System.out.println("il vous reste " + aventurier.getVie());
		}
	}
}
