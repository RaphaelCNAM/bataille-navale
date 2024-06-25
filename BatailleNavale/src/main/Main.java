package main;

import java.awt.Color;
import java.util.Scanner;

import entity.*;
import entity.bateaux.*;
import javax.swing.JFrame;

import interfaceGrafique.WindowFrame;

public class Main {
	 public static void main(String[] args) throws InvalidTirException {
	        // Initialiser les joueurs
		 	boolean winJ=false,winO=false;
	        Joueur joueur = new Joueur();
	        JoueurOrdinateur ordinateur = new JoueurOrdinateur();

	        // Création et placement des bateaux pour le joueur humain
	        Bateau[] bateauxJoueur = new Bateau[5];
	        bateauxJoueur[0] = FabriqueBateau.creerBateau("PorteAvion");
	        bateauxJoueur[1] = FabriqueBateau.creerBateau("Croiseur");
	        bateauxJoueur[2] = FabriqueBateau.creerBateau("SousMarin");
	        bateauxJoueur[3] = FabriqueBateau.creerBateau("SousMarin");
	        bateauxJoueur[4] = FabriqueBateau.creerBateau("Torpilleur");

	        for (Bateau bateau : bateauxJoueur) {
	            joueur.addBateau(bateau);
	        }

	        // Création et placement des bateaux pour l'ordinateur
	        Bateau[] bateauxOrdinateur = new Bateau[5];
	        bateauxOrdinateur[0] = FabriqueBateau.creerBateau("PorteAvion");
	        bateauxOrdinateur[1] = FabriqueBateau.creerBateau("Croiseur");
	        bateauxOrdinateur[2] = FabriqueBateau.creerBateau("SousMarin");
	        bateauxOrdinateur[3] = FabriqueBateau.creerBateau("SousMarin");
	        bateauxOrdinateur[4] = FabriqueBateau.creerBateau("Torpilleur");

	        for (Bateau bateau : bateauxOrdinateur) {
	            ordinateur.addBateau(bateau);
	        }

	        joueur.afficherGrillesCoteACote(ordinateur);

	        Scanner scanner = new Scanner(System.in);
	        while (winJ==false && winO==false) {
	            System.out.print("Entrez les coordonnées pour tirer (ex: A5): ");
	            String coordonnee = scanner.nextLine().toUpperCase();
	            
	            joueur.tirer(coordonnee);
	            ordinateur.autoTire();	    
	            winJ = joueur.isFinish();
	            winO = ordinateur.isFinish();
	            joueur.afficherGrillesCoteACote(ordinateur);
	        }
	        
	        if(winO == true) {
	        	System.out.println("L'ordinateur a Gagner");
	        }else if(winJ == true) {
	        	System.out.println("Vous a Gagner");
	        }
	    }
	    
}
