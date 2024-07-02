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
	        while (!winJ && !winO) {
				boolean tirValide = false;
	
				// Demander la coordonnée jusqu'à ce qu'elle soit valide
				do {
					System.out.print("Entrez les coordonnées pour tirer (ex: A5): ");
					String coordonnee = scanner.nextLine().toUpperCase();
	
					try {
						joueur.tirer(coordonnee);
						tirValide = true; // Le tir est valide
					} catch (InvalidTirException e) {
						System.out.println(e.getMessage());
						System.out.println("Veuillez entrer une nouvelle coordonnée.");
					}
				} while (!tirValide);
	
				// Vérifier si le joueur a gagné
				winJ = joueur.isFinish();
				if (winJ) {
					System.out.println("Vous avez Gagné");
					break;
				}
	
				// Tour de l'ordinateur
				ordinateur.autoTire();
				winO = ordinateur.isFinish();
				if (winO) {
					System.out.println("L'ordinateur a Gagné");
					break;
				}
	
				// Afficher les grilles après chaque tour
				joueur.afficherGrillesCoteACote(ordinateur);
			}
	
			scanner.close();
		}
	}
