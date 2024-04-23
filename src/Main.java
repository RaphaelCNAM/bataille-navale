package bataille_navale.src;

import bataille_navale.Bateau;
import bataille_navale.Coordonnee;

public class Main {
    public static void main(String args[]) throws Exception {
        Coordonnee c1 = new Coordonnee("B6");
        Bateau b = new Bateau(c1, 5, true);
    }
}
