package entity;

import java.util.ArrayList;
import java.util.List;

import entity.bateaux.*;

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

    public void tirer(String coordonnee) {
        int ligne = coordonnee.charAt(0) - 'A';
        int colonne = Integer.parseInt(coordonnee.substring(1)) - 1;

        if (grille[ligne][colonne] == 'O') {
            grille[ligne][colonne] = 'M'; // M pour miss (raté)
        } else {
            grille[ligne][colonne] = 'X'; // X pour hit (touché)
        }
    }

    public void afficherGrille() {
        System.out.println("  ╔═══════════════════════════════════════╗");
        System.out.println("  ║              Votre grille             ║");
        System.out.println("  ╚═══════════════════════════════════════╝");
        System.out.println();
        System.out.print("    ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();

        char[] lettres = "ABCDEFGHIJ".toCharArray();
        for (int j = 0; j < grille.length; j++) {
            if (j == 0) {
                System.out.println("  ╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
            }

            for (int i = 0; i < grille[j].length; i++) {
                if (i == 0) {
                    System.out.print(lettres[j] + " ║");
                } else {
                    System.out.print("║");
                }
                char c = grille[j][i];
                switch (c) {
                    case 'M':
                        System.out.print("\033[34m O \033[0m"); // O bleu pour miss
                        break;
                    case 'X':
                        System.out.print("\033[31m X \033[0m"); // X rouge pour hit
                        break;
                    default:
                        System.out.print(" " + c + " ");
                        break;
                }
            }
            System.out.println("║");

            if (j == grille.length - 1) {
                System.out.println("  ╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
            } else {
                System.out.println("  ╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
            }
        }
        System.out.println();
    }

	public void afficherGrilleOrdi() {
        System.out.println("  ╔═══════════════════════════════════════╗");
        System.out.println("  ║               Grille de Michel        ║");
        System.out.println("  ╚═══════════════════════════════════════╝");
        System.out.println();
        System.out.print("    ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();

        char[] lettres = "ABCDEFGHIJ".toCharArray();
        for (int j = 0; j < grille.length; j++) {
            if (j == 0) {
                System.out.println("  ╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
            }

            for (int i = 0; i < grille[j].length; i++) {
                if (i == 0) {
                    System.out.print(lettres[j] + " ║");
                } else {
                    System.out.print("║");
                }
                char c = grille[j][i];
                switch (c) {
                    case 'M':
                        System.out.print("\033[34m O \033[0m"); // O bleu pour miss
                        break;
                    case 'X':
                        System.out.print("\033[31m X \033[0m"); // X rouge pour hit
                        break;
                    default:
                        System.out.print(" " + c + " ");
                        break;
                }
            }
            System.out.println("║");

            if (j == grille.length - 1) {
                System.out.println("  ╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
            } else {
                System.out.println("  ╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
            }
        }
        System.out.println();
    }
}