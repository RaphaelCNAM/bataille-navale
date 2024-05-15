package entity;

public class Coordonnee {

	private int ligne;
	private int colonne;
	private int id;
	private boolean tire;
	
	private char caracterInitial = 'A';
	
	/*public Coordonnee(String coordonnees) {
		this.colonne = coordonnees.charAt(0)-caracterInitial;
		String ligne = coordonnees.substring(1,2);
		this.ligne = Integer.parseInt(ligne);
	}*/
	
	public Coordonnee(int lig, int col) {
		this.colonne = col;
		this.ligne = lig;
		this.id = 0;
		this.tire = false;

	}

	public void addBateau(int id){
		this.id = id;
	}

	public int getLigne() {
		return ligne;
	}

	public int getColonne() {
		return colonne;
	}

	public void tire(){
		this.tire = true;
	}

	public boolean estTire(){
		return this.tire;
	}

	public int getId(){
		return this.id;
	}
	
	public String toString() {
		return(char)(this.colonne + this.caracterInitial)+""+this.ligne;
	}
	
	public boolean equals(Coordonnee o) {
		
		return this.colonne == o.colonne && this.ligne == o.ligne;
		
	}
}
