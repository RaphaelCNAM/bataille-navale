package interfaceGrafique;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class GamePanel extends JPanel implements Runnable{
	//option d'écrant
	
	final int originalTileSize = 16; //16x16pixel = 1tile
	final int scale = 2;
	
	public final int tileSize = originalTileSize * scale;
	
	public GamePanel() {
	}
	
	public JPanel createGridButtons() {
        JPanel panel = new JPanel(new GridLayout(10,10));        
	    for (int row = 0; row < 10; row++) {
	        for (int col = 0; col < 10; col++) {
	            JButton button = new JButton();
	            button.setPreferredSize(new Dimension(tileSize, tileSize));
	            panel.add(button);
	        }
	    }
	    return panel;
	}
	
	public JPanel informationPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JTextArea zoneTexte = new JTextArea("Ici vous verrez les informations de toucher/couler sur tous les bateaux ennemis.");
        zoneTexte.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(zoneTexte);
        panel.add(scrollPane, BorderLayout.CENTER);
		return panel;
	}
	
	public void run() {
		
	}
}
