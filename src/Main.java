package bataille_navale.src;

import bataille_navale.Bateau;
import bataille_navale.Coordonnee;

public class Main {
    public static void main(String args[]) throws Exception {
        Coordonnee debut = new Coordonnee("A1");
        Bateau bateau1 = new Bateau(debut, 4, true);
        System.out.println("Bateau1: Début: " + bateau1.getDebut() + ", Fin: " + bateau1.getFin());

        Coordonnee debut2 = new Coordonnee("D5");
        Bateau bateau2 = new Bateau(debut2, 3, false);
        System.out.println("Bateau2: Début: " + bateau2.getDebut() + ", Fin: " + bateau2.getFin());

        // Vérification des coordonnées
        Coordonnee coord1 = new Coordonnee("B2");
        Coordonnee coord2 = new Coordonnee("C2");
        Coordonnee coord3 = new Coordonnee("D2");
        Coordonnee coord4 = new Coordonnee("E2");

        System.out.println("Coord1: " + coord1);
        System.out.println("Coord2: " + coord2);
        System.out.println("Coord3: " + coord3);
        System.out.println("Coord4: " + coord4);

        System.out.println("Le bateau 1 contient la coord1: " + bateau1.contient(coord1));
        System.out.println("Le bateau 1 contient la coord2: " + bateau1.contient(coord2));
        System.out.println("Le bateau 1 contient la coord3: " + bateau1.contient(coord3));
        System.out.println("Le bateau 1 contient la coord4: " + bateau1.contient(coord4));

        System.out.println("Le bateau 2 contient la coord1: " + bateau2.contient(coord1));
        System.out.println("Le bateau 2 contient la coord2: " + bateau2.contient(coord2));
        System.out.println("Le bateau 2 contient la coord3: " + bateau2.contient(coord3));
        System.out.println("Le bateau 2 contient la coord4: " + bateau2.contient(coord4));
    }
}
