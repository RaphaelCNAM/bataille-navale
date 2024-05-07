package interfaceGrafique;

import java.awt.Color;

import javax.swing.JFrame;

public class Window {
	
	public JFrame createWindow() {
		JFrame window = new JFrame();
		int xFrame = 800; int yFrame = 600;
		window.setSize(xFrame, yFrame);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);

		window.setLocationRelativeTo(null);
		window.setVisible(true);
		return window;
	}
}