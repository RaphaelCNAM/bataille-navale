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

public class GamePanel extends JPanel implements Runnable{
	//option d'écrant
	
	final int originalTileSize = 16; //16x16pixel = 1tile
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale;
	
	public GamePanel() {
	}
	
	public JPanel createGridButtons() {
        JPanel panel = new JPanel(new GridLayout(10,10));        
	    for (int row = 0; row < 10; row++) {
	        for (int col = 0; col < 10; col++) {
	            JButton button = new JButton();
	            button.setPreferredSize(new Dimension(tileSize, tileSize));
	            button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	if(button.getBackground() == Color.red) {//modifier pour que ce soit les bateau qui donne la couleur des boutons
                    		button.setBackground(Color.black);
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
