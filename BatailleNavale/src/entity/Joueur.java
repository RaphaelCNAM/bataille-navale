package entity;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private char[][] grille;
    private List<Bateau> bateaux;

    public Joueur() {
        // Initialiser une grille 10x10 remplie de 'O'
        grille = new char[10][10];
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                grille[i][j] = 'O';
            }
        }
        bateaux = new ArrayList<>();
    }

    public char[][] getGrille() {
        return grille;
    }

    public List<Bateau> getBateaux() {
        return bateaux;
    }

    public void addBateau(Bateau bateau) {
        while (!placerBateauSansChevauchement(bateau)) {
            int x = (int) (Math.random() * (10 - bateau.getTaille() + 1));
            int y = (int) (Math.random() * (10 - bateau.getTaille() + 1));
            boolean estVertical = Math.random() < 0.5;

            if (bateau instanceof PorteAvion) {
                bateau = new PorteAvion(new Coordonnee(x, y), estVertical);
            } else if (bateau instanceof Croiseur) {
                bateau = new Croiseur(new Coordonnee(x, y), estVertical);
            } else if (bateau instanceof SousMarin) {
                bateau = new SousMarin(new Coordonnee(x, y), estVertical);
            } else if (bateau instanceof Torpilleur) {
                bateau = new Torpilleur(new Coordonnee(x, y), estVertical);
            }
        }
        bateaux.add(bateau);
        bateau.placerSurGrille(grille);
    }

    public boolean placerBateauSansChevauchement(Bateau bateau) {
        Coordonnee debut = bateau.getDebut();
        Coordonnee fin = bateau.getFin();

        if (bateau.estVertical()) {
            for (int row = debut.getLigne(); row <= fin.getLigne(); row++) {
                if (grille[row][debut.getColonne()] != 'O') {
                    return false; // Chevauchement détecté
                }
            }
        } else {
            for (int col = debut.getColonne(); col <= fin.getColonne(); col++) {
                if (grille[debut.getLigne()][col] != 'O') {
                    return false; // Chevauchement détecté
                }
            }
        }
        return true;
    }

    public void afficherGrille() {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }
}
