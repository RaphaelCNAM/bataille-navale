package interfaceGrafique;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{
	//option d'écrant
	
	final int originalTileSize = 16; //16x16pixel = 1tile
	final int scale = 3;
	
	public final int tileSize = originalTileSize * scale; //48x48 tile	
	public final int maxScreenCol = 16;
	public final int maxScreenRow = 12;		
	public final int screenWidht = tileSize * maxScreenCol; //768 pixel
	public final int screenHeight = tileSize * maxScreenRow; //576 pixel
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidht,screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.setFocusable(true);
		createGridButtons();
	}
	
	public void createGridButtons() {
        JPanel panel = new JPanel(new GridLayout(10,10));        
	    for (int row = 0; row < 10; row++) {
	        for (int col = 0; col < 10; col++) {
	            JButton button = new JButton();
	            button.setPreferredSize(new Dimension(tileSize, tileSize));
	            panel.add(button);
	        }
	    }
	    panel.setBounds(50, 50, 200, 200);
	    this.add(panel);
	}


	
	public void run() {
		
	}
}
