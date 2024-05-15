package entity;

public class Croiseur extends Bateau {
    public Croiseur(Coordonnee debut, boolean estVertical) {
        super(debut, 4, estVertical);
        this.setName("Croiseur");
    }
}
