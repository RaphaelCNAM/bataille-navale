package entity;

public class SousMarin extends Bateau {

    public SousMarin(Coordonnee debut, boolean estVertical) {
        super(debut, 3, estVertical);
        this.setName("Sous-Marin");
    }
}
