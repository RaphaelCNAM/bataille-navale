package entity.bateaux;

import entity.Bateau;
import entity.Coordonnee;

public class Croiseur extends Bateau {
	private String name;
	
	  public Croiseur(Coordonnee debut, boolean estVertical) {
	        super(debut, 4, estVertical);
	        this.setName("Croiseur");
	    }
}
