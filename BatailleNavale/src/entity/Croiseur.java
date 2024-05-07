package entity;

public class Croiseur extends Bateau{

    public Croiseur(Coordonnee debut, int longeur, boolean estVertical) {
        super(debut, longeur, estVertical);
        this.name  = "Croiseur";
        this.taille = 4;
    }

}
