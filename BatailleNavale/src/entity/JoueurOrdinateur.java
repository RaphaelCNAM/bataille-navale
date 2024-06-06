package entity;

import java.util.List;
import java.util.Random;

public class JoueurOrdinateur extends Joueur {

    private List<Coordonnee> tirs;
    private char[][] grille = getGrille();

    public JoueurOrdinateur() {
        super();
    }

    public void autoTire() {
        int ligne = new Random().nextInt(9 - 1 + 1) + 1;
        int colonne = new Random().nextInt(9 - 1 + 1) + 1;

        if (this.grille[ligne][colonne] == 'O') {
            grille[ligne][colonne] = 'M'; // M pour miss (raté)
        } else {
            grille[ligne][colonne] = 'X'; // X pour hit (touché)
        }
    }

    // Peut ajouter des méthodes spécifiques pour l'ordinateur si nécessaire
}
