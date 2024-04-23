package bataille_navale;

public class Bateau {
    private Coordonnee debut;
    private Coordonnee fin;
    private Coordonnee[] partiesTouchees;
    private int nbTouchees;

    public Bateau(Coordonnee debut, int longueur, boolean estVertical) {

        this.debut = debut;

        if (estVertical) {

            fin = new Coordonnee(this.debut.getColonne(), this.debut.getLigne() + longueur - 1);

        } else {

            fin = new Coordonnee(this.debut.getColonne() + longueur - 1, this.debut.getLigne());

        }

        partiesTouchees = new Coordonnee[longueur];
        nbTouchees = 0;

    }

    public Coordonnee getDebut() {
        return this.debut;
    }

    public Coordonnee getFin() {
        return fin;
    }

    public boolean contient(Coordonnee c) {

        return c.getColonne() >= debut.getColonne()
                && c.getColonne() <= fin.getColonne()
                && c.getLigne() >= debut.getLigne()
                && c.getLigne() <= fin.getLigne();

    }

    public boolean chevauche(Bateau n) {

        if (this.debut.getLigne() == this.fin.getLigne()) {
            return n.debut.getColonne() >= this.debut.getColonne()
                    && n.debut.getColonne() <= this.fin.getColonne()
                    && this.debut.getLigne() >= n.debut.getLigne()
                    && this.debut.getLigne() <= n.fin.getLigne();
        } else {
            return n.debut.getLigne() >= this.debut.getLigne()
                    && n.debut.getLigne() <= this.fin.getLigne()
                    && this.debut.getColonne() <= n.debut.getColonne()
                    && this.debut.getColonne() <= n.fin.getColonne();
        }

    }

    public boolean touche(Bateau n) {

        return false;

    }

    public boolean estTouche(Coordonnee c) {

        for (int i = 0; i < partiesTouchees.length; i++) {

            if (partiesTouchees[i].equals(c)) {
                return true;
            }

        }

        return false;

    }

    public boolean recoitTir(Coordonnee c) {

        if (this.contient(c)) {
            partiesTouchees[nbTouchees] = c;
            nbTouchees++;
            return true;
        }

        return false;

    }

    public boolean estTouche() {
        return nbTouchees > 0;
    }

    public boolean estCoule() {
        return nbTouchees == this.partiesTouchees.length;
    }
}
