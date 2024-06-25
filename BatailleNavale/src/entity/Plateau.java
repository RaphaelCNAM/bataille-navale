package entity;

public class Plateau {
    private Coordonnee[][] plateau;
    private Bateau[] bateaux;
    private int nbBateaux;

    public Plateau() {
        this.plateau = generateBlankBoard(10, 10);
    }

    public Coordonnee getCoordonnee(int x, int y) {
        return plateau[x][y];
    }

    private Coordonnee[][] generateBlankBoard(int w, int h) {
        Coordonnee[][] result = new Coordonnee[w][h];
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                result[i][j] = new Coordonnee(i, j);
            }
        }
        return result;
    }
}
