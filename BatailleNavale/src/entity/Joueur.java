package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import entity.bateaux.*;

public class Joueur {
    private char[][] grille;
    private List<Bateau> bateaux;

    public Joueur() {
        // Initialiser une grille 10x10 remplie de 'O'
        grille = new char[10][10];
        for (char[] row : grille) {
            Arrays.fill(row, 'O');
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

    public void tirer(String coordonnee) throws InvalidTirException {
        if (coordonnee.length() < 2 || coordonnee.length() > 3) {
            throw new InvalidTirException("Coordonnée invalide : " + coordonnee);
        }

        int ligne = coordonnee.charAt(0) - 'A';
        int colonne;
        try {
            colonne = Integer.parseInt(coordonnee.substring(1)) - 1;
        } catch (NumberFormatException e) {
            throw new InvalidTirException("Coordonnée invalide : " + coordonnee);
        }

        if (ligne < 0 || ligne >= 10 || colonne < 0 || colonne >= 10) {
            throw new InvalidTirException("Coordonnée hors de la grille : " + coordonnee);
        }

        if (grille[ligne][colonne] == 'M' || grille[ligne][colonne] == 'X') {
            throw new InvalidTirException("Case déjà tirée : " + coordonnee);
        }

        if (grille[ligne][colonne] == 'O') {
            grille[ligne][colonne] = 'M'; // M pour miss (raté)
            System.out.println("Votre missile est dans la mer");
        } else {
            grille[ligne][colonne] = 'X'; // X pour hit (touché)
            System.out.println("Votre missile a touché");
        }
    }

    public boolean buttonTirer(Coordonnee coordonnee) {
        int ligne = coordonnee.getLigne();
        int colonne = coordonnee.getColonne();
        if (grille[ligne][colonne] != 'O') {
            return true;
        }
        return false;
    }

    public void afficherGrillesCoteACote(Joueur autreJoueur) {
        char[][] grille1 = this.getGrille();
        char[][] grille2 = autreJoueur.getGrille();

        System.out.println(
                "  ╔═══════════════════════════════════════╗              ╔═══════════════════════════════════════╗");
        System.out.println(
                "  ║        Grille de l'Ordinateur         ║              ║             Votre grille              ║");
        System.out.println(
                "  ╚═══════════════════════════════════════╝              ╚═══════════════════════════════════════╝");
        System.out.println();
        System.out.print("    ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + "   ");
        }
        System.out.print("             ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(" " + i + "  ");
        }
        System.out.println();

        char[] lettres = "ABCDEFGHIJ".toCharArray();
        for (int j = 0; j < grille1.length; j++) {
            if (j == 0) {
                System.out.println(
                        "  ╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗              ╔═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
            }

            // Afficher la grille de l'ordinateur
            System.out.print(lettres[j] + " ║");
            for (int i = 0; i < grille1[j].length; i++) {
                char c = grille1[j][i];
                switch (c) {
                    case 'M':
                        System.out.print("\033[34m O \033[0m"); // O bleu pour miss
                        break;
                    case 'X':
                        System.out.print("\033[31m X \033[0m"); // X rouge pour hit
                        break;
                    default:
                        System.out.print("   ");
                        break;
                }
                if (i < grille1[j].length - 1) {
                    System.out.print("║");
                }
            }
            System.out.print("║            ");

            // Afficher la grille du joueur
            System.out.print(lettres[j] + " ║");
            for (int i = 0; i < grille2[j].length; i++) {
                char c = grille2[j][i];
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
                if (i < grille2[j].length - 1) {
                    System.out.print("║");
                }
            }
            System.out.println("║");

            if (j == grille1.length - 1) {
                System.out.println(
                        "  ╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝              ╚═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
            } else {
                System.out.println(
                        "  ╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣              ╠═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
            }
        }
        System.out.println();
    }

    public boolean isFinish() {
        int cpt = 0;
        for (char[] row : this.grille) {
            for (char cell : row) {
                if (cell == 'X') {
                    cpt++;
                }
            }
        }
        System.out.println(cpt);
        return cpt == 17;
    }
}
