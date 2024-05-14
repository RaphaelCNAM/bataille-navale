package entity;

import java.awt.Color;
import java.awt.Graphics;

public class Bateau {
    private Coordonnee debut;
    private Coordonnee fin;
    private Coordonnee[] partiesTouchees;
    private int nbTouchees;
    protected String name;
    protected int taille;
    
    public Bateau(Coordonnee debut, int longueur, boolean estVertical) {
        this.debut = debut;
        
        if (estVertical) {
            this.fin = new Coordonnee(this.debut.getColonne(), this.debut.getLigne() + longueur - 1);
        } else {
            this.fin = new Coordonnee(this.debut.getColonne() + longueur - 1, this.debut.getLigne());
        }
        
        this.partiesTouchees = new Coordonnee[longueur];
        this.nbTouchees = 0;
    }
    
    public Coordonnee getDebut() {
        return this.debut;
    }
    
    public Coordonnee getFin() {
        return this.fin;
    }
    
    public boolean contient(Coordonnee c) {
        return c.getColonne() >= this.debut.getColonne() &&
               c.getColonne() <= this.fin.getColonne() &&
               c.getLigne() >= this.debut.getLigne() &&
               c.getLigne() <= this.fin.getLigne();
    }
    
    public boolean chevauche(Bateau b) {
        if (this.debut.getLigne() == this.fin.getLigne()) {
            return b.debut.getColonne() >= this.debut.getColonne() &&
                   b.debut.getColonne() <= this.fin.getColonne() &&
                   this.debut.getLigne() >= b.debut.getColonne() &&
                   this.fin.getLigne() <= b.fin.getLigne();
        } else {
            return b.debut.getLigne() >= this.debut.getLigne() &&
                   b.debut.getLigne() <= this.fin.getLigne() &&
                   this.debut.getColonne() >= b.debut.getColonne() &&
                   this.debut.getColonne() <= b.fin.getColonne();
        }
    }
    
    public boolean estTouche(Coordonnee c) {
        for (int i = 0; i < this.partiesTouchees.length; i++) {
            if (this.partiesTouchees[i] != null && this.partiesTouchees[i].equals(c)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean recoitTir(Coordonnee c) {
        if (this.contient(c)) {
            if (this.nbTouchees < this.partiesTouchees.length) {
                this.partiesTouchees[this.nbTouchees] = c;
                this.nbTouchees++;
                return true;
            } else {
                // Handle case where all parts have been hit
                return false;
            }
        }
        return false;
    }
    
    public boolean estTouche() {
        return this.nbTouchees > 0;
    }
    
    public boolean estCoule() {
        return this.nbTouchees == this.partiesTouchees.length;
    }
    
    public void dessiner(Graphics g) {
        // Dessiner le bateau sur l'interface graphique
        // Vous devez implémenter cette méthode en fonction de votre interface graphique
        g.setColor(Color.WHITE); // Par exemple, couleur bleue pour le bateau
        // Dessinez un rectangle ou tout autre forme pour représenter le bateau
        g.fillRect(debut.getColonne(), debut.getLigne(), fin.getColonne() - debut.getColonne(), fin.getLigne() - debut.getLigne());
    }

    public boolean estVertical() {
        return this.debut.getColonne() == this.fin.getColonne();
    }
    


    public void placerSurGrille(char[][] grille) {
        Coordonnee debut = this.getDebut();
        Coordonnee fin = this.getFin();
    
        if (this.estVertical()) {
            for (int row = debut.getLigne(); row <= fin.getLigne(); row++) {
                grille[row][debut.getColonne()] = 'X';
            }
        } else {
            for (int col = debut.getColonne(); col <= fin.getColonne(); col++) {
                grille[debut.getLigne()][col] = 'X';
            }
        }
    }
    
    

}
