package entity;

public class PorteAvion extends Bateau{

    public PorteAvion(Coordonnee debut, int longeur, boolean estVertical) {
        super(debut, longeur, estVertical);
        this.name = "Porte-Avion";
        this.taille = 5;
    }

}
