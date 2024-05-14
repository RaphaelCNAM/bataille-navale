package main;

import entity.Bateau;
import entity.Coordonnee;
import entity.Croiseur;
import entity.PorteAvion;

public class Main {
    public static void main(String[] args) {
        // Création d'une grille de 10x10 remplie de O
        char[][] grille = new char[10][10];
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                grille[i][j] = 'O';
            }
        }

        // Création d'un bateau
        int x = (int) (Math.random() * 8); // Génère une coordonnée x aléatoire
        int y = (int) (Math.random() * 8); // Génère une coordonnée y aléatoire
        boolean estHorizontal = Math.random() < 0.5; // Génère une orientation aléatoire
        PorteAvion bateau = new PorteAvion(new Coordonnee(2, 2), 5, estHorizontal); // Création du bateau

        // Placement du bateau sur la grille
        bateau.placerSurGrille(grille);

        // Affichage de la grille dans le terminal
        afficherGrille(grille);
        System.out.println("Position du bateau : (" + 1 + ", " + 5 + ")");
        System.out.println("Orientation : " + (estHorizontal ? "Horizontal" : "Vertical"));
    }

    // Méthode pour afficher la grille dans le terminal
    public static void afficherGrille(char[][] grille) {
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                System.out.print(grille[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
