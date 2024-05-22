package entity;

public class Bateau {
    private Coordonnee debut;
    private Coordonnee fin;
    private String name;
    private int taille;
    private boolean estVertical;

    public Bateau(Coordonnee debut, int longueur, boolean estVertical) {
        this.debut = debut;
        this.estVertical = estVertical;
        this.taille = longueur;
        if (estVertical) {
            this.fin = new Coordonnee(debut.getLigne() + longueur - 1, debut.getColonne());
        } else {
            this.fin = new Coordonnee(debut.getLigne(), debut.getColonne() + longueur - 1);
        }
    }

    public Coordonnee getDebut() {
        return this.debut;
    }

    public Coordonnee getFin() {
        return this.fin;
    }

    public int getTaille() {
        return this.taille;
    }

    public boolean estVertical() {
        return this.estVertical;
    }

    public String getName() {
        return this.name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public void placerSurGrille(char[][] grille) {
        Coordonnee debut = this.getDebut();
        Coordonnee fin = this.getFin();
        char initiale = this.name.charAt(0);

        if (this.estVertical()) {
            for (int row = debut.getLigne(); row <= fin.getLigne(); row++) {
                grille[row][debut.getColonne()] = initiale;
            }
        } else {
            for (int col = debut.getColonne(); col <= fin.getColonne(); col++) {
                grille[debut.getLigne()][col] = initiale;
            }
        }
    }

    public boolean peutPlacerBateau(char[][] grille, Coordonnee debut, int longueur, boolean estVertical) {
        if (estVertical) {
            if (debut.getLigne() + longueur > grille.length) return false;
            for (int i = 0; i < longueur; i++) {
                if (grille[debut.getLigne() + i][debut.getColonne()] != 'O') return false;
            }
        } else {
            if (debut.getColonne() + longueur > grille[0].length) return false;
            for (int i = 0; i < longueur; i++) {
                if (grille[debut.getLigne()][debut.getColonne() + i] != 'O') return false;
            }
        }
        return true;
    }
}
