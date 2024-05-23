package entity.bateaux;

import entity.Bateau;
import entity.Coordonnee;

public class Torpilleur extends Bateau {
	 public Torpilleur(Coordonnee debut, boolean estVertical) {
	        super(debut, 2, estVertical);
	        this.setName("Torpilleur");
	    }
}
