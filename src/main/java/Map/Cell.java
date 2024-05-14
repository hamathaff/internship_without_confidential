package Map;

public class Cell {
    private boolean northWall;
    private boolean southWall;
    private boolean eastWall;
    private boolean westWall;
    private Mybox floor;  // Ajout d'un sol en tant que Mybox pour chaque cellule

    public Cell() {
        // Initialisation du sol avec les dimensions souhaitées (vous pouvez ajuster selon le scale de votre grille)
        this.floor = new Mybox(100, 10, 100);
    }

    // Getters and setters pour floor
    public Mybox getFloor() {
        return floor;
    }

    public void setFloor(Mybox floor) {
        this.floor = floor;
    }

    // Méthodes pour les murs, comme précédemment}
    public void setNorthWall(boolean northWall) {
        this.northWall = northWall;
    }

    public void setEastWall(boolean b) {
        this.eastWall=b;
    }

    // Similar methods for south, east, and west walls
}
