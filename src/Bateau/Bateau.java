public class Bateau {
    private int id;
    protected String name;
    private boolean destroy;
    protected int taille;
    private int touched;

    public Bateau(int id) {
        this.id = id;
        this.destroy = false;
        this.touched = 0;
    }

    public boolean isDestroy() {
        return this.destroy;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setDestroy(boolean destroy) {
        this.destroy = destroy;
    }

    public int getTaille() {
        return this.taille;
    }

    public int getTouched() {
        return this.touched;
    }

    public void incrementTouched() {
        this.touched++;
    }
}