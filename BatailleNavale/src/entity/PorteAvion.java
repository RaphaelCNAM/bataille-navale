package entity;

public class PorteAvion extends Bateau {
    public PorteAvion(Coordonnee debut, boolean estVertical) {
        super(debut, 5, estVertical);
        this.setName("Porte-Avion");
    }
}
