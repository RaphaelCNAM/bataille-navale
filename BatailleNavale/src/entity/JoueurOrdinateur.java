package entity;

import java.util.List;

public class JoueurOrdinateur extends Joueur {
	
	private List<Coordonnee> tires;
	private char[][] grille;
	
    public JoueurOrdinateur() {
        super();
    }
    
    public void autoTire(){
    	int ligne = (int) Math.random()*10-1+1;
    	int colonne = (int) Math.random()*10-1+1;
    	
    	if (this.grille[ligne][colonne] == 'O') {
            grille[ligne][colonne]='M'; // M pour miss (raté)
        } else {
            grille[ligne][colonne]='X'; // X pour hit (touché)
        }
    }
    
    // Peut ajouter des méthodes spécifiques pour l'ordinateur si nécessaire
}