package interfaceGrafique;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import entity.Bateau;

public class WindowFrame extends JFrame {
    private List<Bateau> listBateaux;
    private GamePanel gamePanel;

    public WindowFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("Le jeu");
        this.listBateaux = new ArrayList<>();
        this.gamePanel = new GamePanel();
        add(gamePanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void ajouterBateau(Bateau bateau) {
        listBateaux.add(bateau);
        gamePanel.repaint(); // Repaint du panneau de jeu pour rafraîchir l'affichage des bateaux
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Dessinez tous les bateaux présents dans la liste
        for (Bateau bateau : listBateaux) {
            // Par exemple, vous pouvez appeler la méthode dessiner de la classe Bateau
            // en passant le Graphics g en argument pour dessiner chaque bateau
            bateau.dessiner(g);
        }
    }

	public GamePanel getGamePanel() {
        return gamePanel; // Renvoie une référence au panneau de jeu
    }
}
