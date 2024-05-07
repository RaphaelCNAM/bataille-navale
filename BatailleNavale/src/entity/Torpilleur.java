package entity;

public class Torpilleur extends Bateau{

    public Torpilleur(Coordonnee debut, int longeur, boolean estVertical) {
        super(debut, longeur, estVertical);
        this.name = "Torpilleur";
        this.taille = 2;
    }

}
