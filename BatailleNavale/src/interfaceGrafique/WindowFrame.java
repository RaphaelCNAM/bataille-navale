package interfaceGrafique;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class WindowFrame {
	
	public JFrame createWindow() {
		JFrame fenetre = new JFrame();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setResizable(false);
        fenetre.setSize(768, 576);
        fenetre.setTitle("Le jeux");
        
        GamePanel GamePanels = new GamePanel();
        
        JPanel panelGauche = GamePanels.createGridButtons();
        JPanel panelDroite = GamePanels.informationPanel();
        
        panelGauche.setBackground(Color.BLUE);
        panelDroite.setBackground(Color.RED);
        
        JPanel conteneur = new JPanel();
        conteneur.setLayout(new BoxLayout(conteneur, BoxLayout.X_AXIS));

        conteneur.add(panelGauche);
        conteneur.add(panelDroite);
        
        fenetre.add(conteneur);

		fenetre.setVisible(true);
		return fenetre;
	}
}