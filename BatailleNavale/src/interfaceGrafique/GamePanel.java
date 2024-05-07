package interfaceGrafique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import entity.Bateau;

public class GamePanel extends JPanel implements Runnable {
    final int originalTileSize = 16; //16x16pixel = 1tile
    final int scale = 3;
    
    public final int tileSize = originalTileSize * scale; //48x48 tile   
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;      
    public final int screenWidht = tileSize * maxScreenCol; //768 pixel
    public final int screenHeight = tileSize * maxScreenRow; //576 pixel
    
    private List<Bateau> listBateaux;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidht, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.listBateaux = new ArrayList<>();
    }

    public void addBateau(Bateau bateau) {
        listBateaux.add(bateau);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dessinez tous les bateaux présents dans la liste
        for (Bateau bateau : listBateaux) {
            // Par exemple, vous pouvez appeler la méthode dessiner de la classe Bateau
            // en passant le Graphics g en argument pour dessiner chaque bateau
            bateau.dessiner(g);
        }
    }

    public void run() {
        // Code de votre méthode run si nécessaire
    }
}
