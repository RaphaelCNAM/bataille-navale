package interfaceGrafique;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.UIManager;



public class WindowFrame {
	
	public JFrame createWindow() {
		JFrame window = new JFrame();
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Le jeux");
		
		GamePanel gamepanel = new GamePanel();
		window.add(gamepanel);
		
		window.pack();

		window.setLocationRelativeTo(null);
		window.setVisible(true);
		return window;
	}
}