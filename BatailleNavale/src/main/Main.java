package main;

import entity.Bateau;
import entity.Coordonnee;
import entity.Croiseur;
import entity.PorteAvion;
import entity.SousMarin;
import entity.Torpilleur;

public class Main {
    public static void main(String[] args) {
        // Création d'une grille de 10x10 remplie de O
        char[][] grille = new char[10][10];
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                grille[i][j] = 'O';
            }
        }

        // Création et placement des bateaux
        Bateau[] bateaux = new Bateau[5];
        bateaux[0] = new PorteAvion(new Coordonnee((int) (Math.random() * 6), (int) (Math.random() * 6)), Math.random() < 0.5);
        bateaux[1] = new Croiseur(new Coordonnee((int) (Math.random() * 7), (int) (Math.random() * 7)), Math.random() < 0.5);
        bateaux[2] = new SousMarin(new Coordonnee((int) (Math.random() * 8), (int) (Math.random() * 8)), Math.random() < 0.5);
        bateaux[3] = new SousMarin(new Coordonnee((int) (Math.random() * 8), (int) (Math.random() * 8)), Math.random() < 0.5);
        bateaux[4] = new Torpilleur(new Coordonnee((int) (Math.random() * 9), (int) (Math.random() * 9)), Math.random() < 0.5);

        for (Bateau bateau : bateaux) {
            while (!placerBateauSansChevauchement(grille, bateau)) {
                // Repositionner le bateau s'il y a chevauchement
                int x = (int) (Math.random() * (10 - bateau.getTaille()));
                int y = (int) (Math.random() * (10 - bateau.getTaille()));
                boolean estVertical = Math.random() < 0.5;

                // Recréer le bateau avec une nouvelle position
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
        }

        // Affichage de la grille dans le terminal
        afficherGrille(grille);
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

    // Méthode pour vérifier et placer un bateau sans chevauchement
    public static boolean placerBateauSansChevauchement(char[][] grille, Bateau bateau) {
        Coordonnee debut = bateau.getDebut();
        Coordonnee fin = bateau.getFin();

        if (bateau.estVertical()) {
            for (int row = debut.getLigne(); row <= fin.getLigne(); row++) {
                if (grille[row][debut.getColonne()] != 'O') {
                    return false; // Chevauchement détecté
                }
            }
            for (int row = debut.getLigne(); row <= fin.getLigne(); row++) {
                grille[row][debut.getColonne()] = bateau.getName().charAt(0);
            }
        } else {
            for (int col = debut.getColonne(); col <= fin.getColonne(); col++) {
                if (grille[debut.getLigne()][col] != 'O') {
                    return false; // Chevauchement détecté
                }
            }
            for (int col = debut.getColonne(); col <= fin.getColonne(); col++) {
                grille[debut.getLigne()][col] = bateau.getName().charAt(0);
            }
        }
        return true;
    }
}
