package entity;
import entity.bateaux.*;

public class FabriqueBateau {
    public static Bateau creerBateau(String type) {
        Coordonnee coordonnee;
        boolean orientation = Math.random() < 0.5;

        switch (type) {
            case "PorteAvion":
                coordonnee = new Coordonnee((int) (Math.random() * 6), (int) (Math.random() * 6));
                return new PorteAvion(coordonnee, orientation);
            case "Croiseur":
                coordonnee = new Coordonnee((int) (Math.random() * 7), (int) (Math.random() * 7));
                return new Croiseur(coordonnee, orientation);
            case "SousMarin":
                coordonnee = new Coordonnee((int) (Math.random() * 8), (int) (Math.random() * 8));
                return new SousMarin(coordonnee, orientation);
            case "Torpilleur":
                coordonnee = new Coordonnee((int) (Math.random() * 9), (int) (Math.random() * 9));
                return new Torpilleur(coordonnee, orientation);
            default:
                throw new IllegalArgumentException("Type de bateau inconnu");
        }
    }
}
