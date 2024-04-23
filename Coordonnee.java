package bataille_navale;

public class Coordonnee {

    private int ligne = 0;
    private int colonne = 0;
    private char caractereA = 'A';

    public Coordonnee(String coordonnees) {

        this.colonne = coordonnees.charAt(0) - caractereA;

        String ligne = coordonnees.substring(1, 2);
        this.ligne = Integer.parseInt(ligne);

    }

    public Coordonnee(int colonne,int ligne) {

        this.ligne = ligne;
        this.colonne = colonne;

    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public String toString() {
        
        String coordonnees = new String();
        
        coordonnees = coordonnees + (char)(colonne + caractereA) + ligne;
        
        return coordonnees;
        
    }
    
    public boolean equals(Coordonnee o){
        
        return this.colonne == o.colonne
                && this.ligne == o.ligne;
        
    }

}
