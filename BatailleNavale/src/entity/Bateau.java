package entity;

public class Bateau {
	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees;
	
	public Bateau(Coordonnee debut,int longeur,boolean estVertical){
		this.debut = debut;
		
		if(estVertical) {
			this.fin = new Coordonnee(this.debut.getColonne(), this.debut.getLigne()+longeur-1);
		}else{
			this.fin = new Coordonnee(this.debut.getColonne()+longeur-1, this.debut.getLigne());
		}
		
		this.partiesTouchees = new Coordonnee[longeur];
		
		
		this.nbTouchees = 0;
	}
	
	public Coordonnee getDebut() {return this.debut;}
	public Coordonnee getFin() {return this.fin;}
	
	public boolean contien(Coordonnee c) {
		return c.getColonne() >= debut.getColonne() &&
				c.getColonne() <= fin.getColonne()&&
				c.getLigne() >= debut.getLigne()&&
				c.getLigne() <= fin.getLigne();
	}
	
	public boolean chevauche(Bateau b) {
		if (this.debut.getLigne() == this.fin.getLigne()) {
			
			return b.debut.getColonne() >= this.debut.getColonne() &&
					b.debut.getColonne() <= this.fin.getColonne()&&
					this.debut.getLigne() >= b.debut.getColonne()&&
					this.fin.getLigne() <= b.fin.getLigne();
		}else {
			return b.debut.getLigne() >= this.debut.getLigne() &&
					b.debut.getLigne() <= this.fin.getLigne()&&
					this.debut.getColonne()	>= b.debut.getColonne() &&
					this.debut.getColonne()	<= b.fin.getColonne();
		}
	}
	
	public boolean estTouche(Coordonnee c) {
		for(int i = 0; i < this.partiesTouchees.length; i++) {
			if(this.partiesTouchees[i].equals(c)) {
				this.nbTouchees ++;
				return true;
			}
		}
		return false;
	}
	
	public boolean recoitTir(Coordonnee c) {
		if(this.contien(c)) {
			this.partiesTouchees[this.nbTouchees] = c;
			this.nbTouchees += 1;
			return true;
		}
		return false;
	}
	
	public boolean estTouche() {
		return this.nbTouchees > 0;
	}
	
	
	public boolean estCoule() {
		return this.partiesTouchees.length == this.nbTouchees;
		
	}
}
