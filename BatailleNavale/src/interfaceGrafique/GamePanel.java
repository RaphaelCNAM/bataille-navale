package interfaceGrafique;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import entity.Coordonnee;
import entity.Joueur;

public class GamePanel extends JPanel implements Runnable{
	//option d'écrant
	
	final int originalTileSize = 16; //16x16pixel = 1tile
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale;
	
	public GamePanel() {
	}
	
	public JPanel createGridButtons(Joueur playeur) {
        JPanel panel = new JPanel(new GridLayout(10,10));        
	    for (int row = 0; row < 10; row++) {
	        for (int col = 0; col < 10; col++) {
	            JButton button = new JButton();
	            button.setPreferredSize(new Dimension(tileSize, tileSize));
	            final int currentRow = row;
	            final int currentCol = col;
	            button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	Coordonnee coor = new Coordonnee(currentRow,currentCol);
                    	boolean bool = playeur.buttonTirer(coor);
                    	if(bool == true) {//modifier pour que ce soit les bateau qui donne la couleur des boutons
                    		button.setBackground(Color.blue);
                    	}else {
                    		button.setBackground(Color.red);	
                    	}
                        
                    }
                });
	            panel.add(button);
	        }
	    }
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
	
	public void run() {
		
	}
}
