package entity;

public class SousMarin extends Bateau{

    public SousMarin(Coordonnee debut, int longeur, boolean estVertical) {
        super(debut, longeur, estVertical);
        this.name = "Sous-Marin";
        this.taille = 3;
    }

}
