package main;

import java.awt.Color;
import java.util.Scanner;

import entity.*;
import entity.bateaux.*;
import javax.swing.JFrame;

import interfaceGrafique.WindowFrame;

public class Main {
	 public static void main(String[] args) {
	        // Initialiser les joueurs
		 	boolean winJ=false,winO=false;
	        Joueur joueur = new Joueur();
	        JoueurOrdinateur ordinateur = new JoueurOrdinateur();

	        // Création et placement des bateaux pour le joueur humain
	        Bateau[] bateauxJoueur = new Bateau[5];
	        bateauxJoueur[0] = new PorteAvion(new Coordonnee((int) (Math.random() * 6), (int) (Math.random() * 6)), Math.random() < 0.5);
	        bateauxJoueur[1] = new Croiseur(new Coordonnee((int) (Math.random() * 7), (int) (Math.random() * 7)), Math.random() < 0.5);
	        bateauxJoueur[2] = new SousMarin(new Coordonnee((int) (Math.random() * 8), (int) (Math.random() * 8)), Math.random() < 0.5);
	        bateauxJoueur[3] = new SousMarin(new Coordonnee((int) (Math.random() * 8), (int) (Math.random() * 8)), Math.random() < 0.5);
	        bateauxJoueur[4] = new Torpilleur(new Coordonnee((int) (Math.random() * 9), (int) (Math.random() * 9)), Math.random() < 0.5);

	        for (Bateau bateau : bateauxJoueur) {
	            joueur.addBateau(bateau);
	        }

	        // Création et placement des bateaux pour l'ordinateur
	        Bateau[] bateauxOrdinateur = new Bateau[5];
	        bateauxOrdinateur[0] = new PorteAvion(new Coordonnee((int) (Math.random() * 6), (int) (Math.random() * 6)), Math.random() < 0.5);
	        bateauxOrdinateur[1] = new Croiseur(new Coordonnee((int) (Math.random() * 7), (int) (Math.random() * 7)), Math.random() < 0.5);
	        bateauxOrdinateur[2] = new SousMarin(new Coordonnee((int) (Math.random() * 8), (int) (Math.random() * 8)), Math.random() < 0.5);
	        bateauxOrdinateur[3] = new SousMarin(new Coordonnee((int) (Math.random() * 8), (int) (Math.random() * 8)), Math.random() < 0.5);
	        bateauxOrdinateur[4] = new Torpilleur(new Coordonnee((int) (Math.random() * 9), (int) (Math.random() * 9)), Math.random() < 0.5);

	        for (Bateau bateau : bateauxOrdinateur) {
	            ordinateur.addBateau(bateau);
	        }

	        joueur.afficherGrille();
	        
	        ordinateur.afficherGrilleOrdi();

	        Scanner scanner = new Scanner(System.in);
	        while (winJ==false && winO==false) {
	            System.out.print("Entrez les coordonnées pour tirer (ex: A5): ");
	            String coordonnee = scanner.nextLine().toUpperCase();
	            
	            joueur.tirer(coordonnee);
	            ordinateur.autoTire();	    
	            winJ = joueur.isFinish();
	            winO = ordinateur.isFinish();
	            ordinateur.afficherGrille();
	            joueur.afficherGrilleOrdi();
	        }
	        
	        if(winO == true) {
	        	System.out.println("L'ordinateur a Gagner");
	        }else if(winJ == true) {
	        	System.out.println("Vous a Gagner");
	        }
	    }
	    
}
