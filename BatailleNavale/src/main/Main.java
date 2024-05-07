package main;

import java.awt.Color;

import javax.swing.JFrame;

import entity.Bateau;
import entity.Coordonnee;
import entity.PorteAvion;
import interfaceGrafique.WindowFrame;

public class Main {
    public static void main(String[] args) {
        // Création de la fenêtre principale
        WindowFrame windowFrame = new WindowFrame();

        // Création d'un bateau à ajouter au panneau de jeu
        int x = (int) (Math.random() * 500); // Génère une coordonnée x aléatoire
        int y = (int) (Math.random() * 500); // Génère une coordonnée y aléatoire
        boolean estVertical = Math.random() < 0.5; // Génère une orientation aléatoire
        PorteAvion bateau = new PorteAvion(new Coordonnee(x, y), 5, estVertical); // Création du bateau

        // Ajout du bateau au panneau de jeu
        windowFrame.getGamePanel().addBateau(bateau);

        // Rafraîchissement de l'affichage
        windowFrame.repaint();
    }
}
