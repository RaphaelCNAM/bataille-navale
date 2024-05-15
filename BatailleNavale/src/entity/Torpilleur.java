package entity;

public class Torpilleur extends Bateau {

    public Torpilleur(Coordonnee debut, boolean estVertical) {
        super(debut, 2, estVertical);
        this.setName("Torpilleur");
    }
}
