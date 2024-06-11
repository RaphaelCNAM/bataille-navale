package interfaceGrafique;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import entity.Coordonnee;
import entity.Joueur;
import entity.JoueurOrdinateur;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16; // 16x16 pixel = 1 tile
    final int scale = 3;
    public final int tileSize = originalTileSize * scale;
    private JLabel statusLabel;
    private List<JButton> buttons; // Liste pour conserver tous les boutons

    public GamePanel() {
        buttons = new ArrayList<>();
    }

    public JPanel createGridButtons(Joueur playeur, JoueurOrdinateur ordi) {
        JPanel panel = new JPanel(new BorderLayout());

        // Créer un panel pour les boutons
        JPanel gridPanel = new JPanel(new GridLayout(10, 10));

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(tileSize, tileSize));
                final int currentRow = row;
                final int currentCol = col;
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        Coordonnee coor = new Coordonnee(currentRow, currentCol);
                        boolean hit = playeur.buttonTirer(coor);
                        if (hit) {
                            button.setBackground(Color.red);
                        } else {
                            button.setBackground(Color.blue);
                        }
                        // Ajouter le tir pour la logique
                        playeur.pui(coor);
                        // Ajouter le tir du bot
                        ordi.autoTire();
                        // Vérifier si le jeu est terminé
                        if (playeur.isFinish() || ordi.isFinish()) {
                            if (playeur.isFinish()) {
                                statusLabel.setText("Joueur gagne!");
                            } else {
                                statusLabel.setText("Joueur perd!");
                            }
                            disableAllButtons(); // Désactiver tous les boutons
                        }
                    }
                });
                
                buttons.add(button); // Ajouter le bouton à la liste
                gridPanel.add(button);
            }
        }

        // Ajouter le panel des boutons au centre du panel principal
        panel.add(gridPanel, BorderLayout.CENTER);

        // Créer et ajouter le label de statut au sud du panel principal
        statusLabel = new JLabel("En cours de jeu...");
        panel.add(statusLabel, BorderLayout.SOUTH);

        return panel;
    }

    public JPanel informationPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea zoneTexte = new JTextArea("Ici vous verrez les informations de \n toucher/couler sur tous les bateaux ennemis.");
        zoneTexte.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(zoneTexte);
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void disableAllButtons() {
        for (JButton button : buttons) {
            button.setEnabled(false); // Désactiver le bouton
        }
    }

    public void run() {
        // Code à exécuter pour lancer le panneau de jeu
    }
}
